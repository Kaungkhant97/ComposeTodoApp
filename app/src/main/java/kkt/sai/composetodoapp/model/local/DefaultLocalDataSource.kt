package kkt.sai.composetodoapp.model.local

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.android.architecture.blueprints.todoapp.data.source.local.TasksDao
import kkt.sai.composetodoapp.entity.OutCome
import kkt.sai.composetodoapp.entity.Task
import kkt.sai.composetodoapp.model.local.LocalDataSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow

class DefaultLocalDataSource internal constructor(private val tasksDao: TasksDao,
                            ) : LocalDataSource {


    override fun getTasks(): Flow<List<Task>> {
        return tasksDao.getTasks();
    }

    override suspend fun insertTask(task:Task) {
        tasksDao.insertTask(task);
    }

    override suspend fun getTask(taskId: String): Task? {
        return tasksDao.getTaskById(taskId);
    }
}