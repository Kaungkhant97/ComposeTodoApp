package kkt.sai.composetodoapp.model

import android.os.Build
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData
import kkt.sai.composetodoapp.entity.Task
import kkt.sai.composetodoapp.model.network.RemoteDataSource
import kotlinx.coroutines.Dispatchers
import kkt.sai.composetodoapp.entity.Result.*


class DefaultTaskRepository(
    private val taskslocalDataSource: LocalDataSource,
    private val tasksRemoteDataSource: RemoteDataSource
) : TaskRepository {


    override fun getTasks(): LiveData<Result<List<Task>>> {
        val data = MutableLiveData<Result<List<Task>>>()
        data.value = taskslocalDataSource.getTasks()

        return data;
    }

    override fun getTasksNetwork(): LiveData<Result<List<Task>>> {
        val Response = liveData(Dispatchers.IO) {
            emit(Loading)
            emit(tasksRemoteDataSource.getTasks())
        }
        return Response as LiveData<Result<List<Task>>>
    }
}