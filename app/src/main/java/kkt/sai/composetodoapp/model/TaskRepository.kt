package kkt.sai.composetodoapp.model

import androidx.lifecycle.LiveData
import kkt.sai.composetodoapp.entity.Task

interface TaskRepository {

    fun getTasks(): LiveData<Result<List<Task>>>;

}