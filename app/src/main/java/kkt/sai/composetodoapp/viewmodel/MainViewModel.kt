package kkt.sai.composetodoapp.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kkt.sai.composetodoapp.entity.OutCome
import kkt.sai.composetodoapp.entity.Task
import kkt.sai.composetodoapp.model.TaskRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val taskRepo :TaskRepository)  : ViewModel() {
<<<<<<< HEAD
    val title: MutableState<String> = mutableStateOf("")
    val description: MutableState<String> = mutableStateOf("")

    fun insertTask() {
        viewModelScope.launch(Dispatchers.IO){
            taskRepo.insertTask(Task(title.value,description.value));
        }

    }


    val _items: LiveData<OutCome<List<Task>>> = taskRepo.getTasksNetwork()
=======
     val _items: LiveData<OutCome<List<Task>>> = taskRepo.getTasksNetwork()
>>>>>>> 791055cc9fff7a8325d04ea55851ce07b7f132e4





}