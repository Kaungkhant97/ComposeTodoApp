package kkt.sai.composetodoapp.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kkt.sai.composetodoapp.entity.Task

class DefaultTaskRepository(
    private val taskslocalDataSource: LocalDataSource
) : TaskRepository {


    override fun getTasks(): LiveData<Result<List<Task>>> {
        val data = MutableLiveData<Result<List<Task>>>();


        data.value = taskslocalDataSource.getTasks();

        return data;
    }

}