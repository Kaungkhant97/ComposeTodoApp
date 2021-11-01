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
import kotlinx.coroutines.flow.map
import java.lang.Error


class DefaultTaskRepository(
    private val taskslocalDataSource: LocalDataSource,
    private val tasksRemoteDataSource: RemoteDataSource
) : TaskRepository {


    override fun getTasks(): Flow<OutCome<List<Task>>> {
        return try {
            taskslocalDataSource.getTasks().map { Success(it) }
        } catch (e: Exception) {
            flow { OutCome.Error(e) }
        }
    }

    override fun getTasksNetwork(): LiveData<OutCome<List<Task>>> {
        val Response = liveData(Dispatchers.IO) {
            emit(Loading)
            kotlinx.coroutines.delay(10000L)
            emit(tasksRemoteDataSource.getTasks())
        }
        return Response
    }

    override suspend fun insertTask(task: Task) {
         taskslocalDataSource.insertTask(task);


    }
}