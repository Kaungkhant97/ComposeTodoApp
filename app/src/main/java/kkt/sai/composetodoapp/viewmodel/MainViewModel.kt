package kkt.sai.composetodoapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kkt.sai.composetodoapp.entity.OutCome
import kkt.sai.composetodoapp.entity.Task
import kkt.sai.composetodoapp.model.TaskRepository

class MainViewModel(val taskRepo :TaskRepository)  : ViewModel() {

    // TODO: Implement the ViewModel
     val _items: LiveData<OutCome<List<Task>>> = taskRepo.getTasksNetwork()





}