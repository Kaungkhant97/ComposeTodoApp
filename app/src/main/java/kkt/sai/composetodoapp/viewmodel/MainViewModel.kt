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
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val taskRepo :TaskRepository)  : ViewModel() {
    val title: MutableState<String> = mutableStateOf("")
    val detail: MutableState<String> = mutableStateOf("")

    fun insertTask() {
        viewModelScope.launch(Dispatchers.IO){
            taskRepo.insertTask(Task(title.value,detail.value));
        }

    }


    fun getTaskDetail(taskId: String?) {

        if(taskId == null){
            title.value = "";
            detail.value = "";
        }else{
            viewModelScope.launch(Dispatchers.IO){
               var taskOutCome =  taskRepo.getTask(taskId);
                if(taskOutCome.succeeded){
                    var task  = (taskOutCome as OutCome.Success<Task>).data;
                    title.value = task.title;
                    detail.value = task.detail;
                }else{
                    //TODO show error
                }
            }
        }

    }








}