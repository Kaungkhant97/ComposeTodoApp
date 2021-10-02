package kkt.sai.composetodoapp.model.network

import kkt.sai.composetodoapp.entity.Task

interface RemoteDataSource {

    suspend fun getTasks(): Result<List<Task>>

}