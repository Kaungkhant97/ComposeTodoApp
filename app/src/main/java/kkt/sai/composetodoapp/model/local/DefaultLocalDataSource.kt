package kkt.sai.composetodoapp.model.local

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.android.architecture.blueprints.todoapp.data.source.local.TasksDao
import kkt.sai.composetodoapp.entity.OutCome
import kkt.sai.composetodoapp.entity.Task
import kkt.sai.composetodoapp.model.local.LocalDataSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class DefaultLocalDataSource internal constructor(private val tasksDao: TasksDao,
                            ) : LocalDataSource {


    override fun getTasks(): Flow<OutCome<List<Task>>> {
        return Transformations.map(tasksDao.getTasks(),{
            OutCome.Success(it);
        })
    }
}