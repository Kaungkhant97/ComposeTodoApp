package kkt.sai.composetodoapp.model.network

import kkt.sai.composetodoapp.entity.Task
import java.lang.Exception

class DefaultRemoteDataSource (val taskService: TaskService) : RemoteDataSource {
    override suspend fun getTasks(): Result<List<Task>> {
        return try {
            Result.success(taskService.getTasks())
        } catch (exception: Exception) {
            Result.failure(exception)
        }
    }
}