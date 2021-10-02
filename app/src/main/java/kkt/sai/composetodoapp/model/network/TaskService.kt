package kkt.sai.composetodoapp.model.network

import kkt.sai.composetodoapp.entity.Task
import retrofit2.http.GET

interface TaskService {
    @GET("/Kaungkhant97/demo/tasks")
    suspend fun getTasks(): List<Task>
}