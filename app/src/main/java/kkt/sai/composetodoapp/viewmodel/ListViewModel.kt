package kkt.sai.composetodoapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kkt.sai.composetodoapp.entity.OutCome
import kkt.sai.composetodoapp.entity.Task
import kkt.sai.composetodoapp.model.TaskRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(private val taskRepo : TaskRepository)  : ViewModel() {
    private val _allTasks = MutableStateFlow<OutCome<List<Task>>>(OutCome.Loading)
    val allTasks: StateFlow<OutCome<List<Task>>> = _allTasks

    init {
        getTasks()
    }

    fun getTasks() {
        viewModelScope.launch {
            taskRepo.getTasks().collect {
                _allTasks.value = it
            }
        }
    }
}