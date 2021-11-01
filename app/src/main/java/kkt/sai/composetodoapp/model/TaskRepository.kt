package kkt.sai.composetodoapp.model

import androidx.lifecycle.LiveData
import kkt.sai.composetodoapp.entity.OutCome
import kkt.sai.composetodoapp.entity.Task
import kotlinx.coroutines.flow.Flow

interface TaskRepository {

    fun getTasks(): Flow<OutCome<List<Task>>>

    fun getTasksNetwork(): LiveData<OutCome<List<Task>>>

    suspend fun insertTask(task:Task);
    suspend fun getTask(taskId:String) : OutCome<Task>;

}