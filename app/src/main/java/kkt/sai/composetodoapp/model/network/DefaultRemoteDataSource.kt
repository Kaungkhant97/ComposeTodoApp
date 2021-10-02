package kkt.sai.composetodoapp.model.network

import kkt.sai.composetodoapp.entity.Result
import kkt.sai.composetodoapp.entity.Task
import java.lang.Exception
import kkt.sai.composetodoapp.entity.Result.*

class DefaultRemoteDataSource (val taskService: TaskService) : RemoteDataSource {
    override suspend fun getTasks(): Result<List<Task>> {
        return try {
            Success(taskService.getTasks())
        } catch (exception: Exception) {
            Error(exception)
        }
    }
}