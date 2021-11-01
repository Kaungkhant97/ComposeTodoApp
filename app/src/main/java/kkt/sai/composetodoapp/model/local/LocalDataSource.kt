package kkt.sai.composetodoapp.model.local

import androidx.lifecycle.LiveData
import kkt.sai.composetodoapp.entity.OutCome
import kkt.sai.composetodoapp.entity.Task
import kotlinx.coroutines.flow.Flow


interface LocalDataSource {

    fun getTasks(): Flow<List<Task>>;

    suspend fun insertTask(task: Task);

    fun getTask(taskId: String): Flow<Task>
    suspend fun updateTask(task: Task);
}