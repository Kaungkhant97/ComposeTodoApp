package kkt.sai.composetodoapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kkt.sai.composetodoapp.entity.OutCome
import kkt.sai.composetodoapp.entity.Task
import kkt.sai.composetodoapp.model.TaskRepository
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val taskRepo :TaskRepository)  : ViewModel() {


     val _items: LiveData<OutCome<List<Task>>> = taskRepo.getTasksNetwork()





}