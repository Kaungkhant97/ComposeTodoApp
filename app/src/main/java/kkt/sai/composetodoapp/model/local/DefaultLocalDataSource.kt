package kkt.sai.composetodoapp.model.local

import com.example.android.architecture.blueprints.todoapp.data.source.local.TasksDao
import kkt.sai.composetodoapp.entity.Task
import kotlinx.coroutines.flow.Flow

class DefaultLocalDataSource internal constructor
    (private val tasksDao: TasksDao) : LocalDataSource {

    override fun getTasks(): Flow<List<Task>> {
        return tasksDao.getTasks()
    }

    override suspend fun insertTask(task:Task) {
        tasksDao.insertTask(task);
    }
}