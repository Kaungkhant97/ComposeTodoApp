package kkt.sai.composetodoapp.model

import androidx.lifecycle.LiveData
import kkt.sai.composetodoapp.entity.OutCome
import kkt.sai.composetodoapp.entity.Task

interface TaskRepository {

//    fun getTasks(): LiveData<OutCome<List<Task>>>

    fun getTasksNetwork(): LiveData<OutCome<List<Task>>>

}