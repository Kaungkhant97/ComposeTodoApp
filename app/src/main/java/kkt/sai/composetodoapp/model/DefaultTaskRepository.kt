package kkt.sai.composetodoapp.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import kkt.sai.composetodoapp.entity.OutCome
import kkt.sai.composetodoapp.entity.Task
import kkt.sai.composetodoapp.model.network.RemoteDataSource
import kotlinx.coroutines.Dispatchers
import kkt.sai.composetodoapp.entity.OutCome.*
import kkt.sai.composetodoapp.model.local.LocalDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
<<<<<<< HEAD
import java.lang.Error
=======
import kotlinx.coroutines.flow.map
import kotlin.Error
>>>>>>> 791055cc9fff7a8325d04ea55851ce07b7f132e4


class DefaultTaskRepository(
    private val tasksLocalDataSource: LocalDataSource,
    private val tasksRemoteDataSource: RemoteDataSource
    ) : TaskRepository {

    override fun getTasks(): Flow<OutCome<List<Task>>> {
        return try {
            tasksLocalDataSource.getTasks().map { Success(it) }
        } catch (e: Error) {
            flow { OutCome.Error(e.localizedMessage) }
        }
    }


    override fun getTasksNetwork(): LiveData<OutCome<List<Task>>> {
        val response = liveData(Dispatchers.IO) {
            emit(Loading)
            kotlinx.coroutines.delay(10000L)
            emit(tasksRemoteDataSource.getTasks())
        }
        return response
    }

    override suspend fun insertTask(task: Task) {
         taskslocalDataSource.insertTask(task);


    }
}