package kkt.sai.composetodoapp.model

import kkt.sai.composetodoapp.entity.Task

interface RemoteDataSource {

    fun getTasks(): Result<List<Task>>

}