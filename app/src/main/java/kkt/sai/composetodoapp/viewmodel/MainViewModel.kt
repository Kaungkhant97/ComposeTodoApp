package kkt.sai.composetodoapp.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kkt.sai.composetodoapp.entity.OutCome
import kkt.sai.composetodoapp.entity.Task
import kkt.sai.composetodoapp.entity.succeeded
import kkt.sai.composetodoapp.model.TaskRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val taskRepo :TaskRepository)  : ViewModel() {
    private var _taskId: String="";
    private var isUpdate: Boolean = false;

    val title: MutableState<String> = mutableStateOf("")
    val detail: MutableState<String> = mutableStateOf("")




    fun updateTask() {
        viewModelScope.launch(Dispatchers.IO){
            if(isUpdate){
              taskRepo.updateTask(Task(title.value,detail.value,id=_taskId));
            }else{
                taskRepo.insertTask(Task(title.value,detail.value));
            }

        }

    }


    fun getTaskDetail(taskId: String?) {

        if(taskId == null){
            title.value = "";
            detail.value = "";
            isUpdate = true;
        }else{
            viewModelScope.launch(Dispatchers.IO){

                taskRepo.getTask(taskId).collect {
                if(it.succeeded){
                    val task =  (it as OutCome.Success).data;
                    title.value = task.title;
                    detail.value = task.detail;
                    _taskId = task.id;
                    isUpdate = true;
                }else{
                    title.value = "";
                    detail.value = "";
                }

                }
            }
        }

    }








}