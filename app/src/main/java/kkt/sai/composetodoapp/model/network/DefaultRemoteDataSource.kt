package kkt.sai.composetodoapp.model.network

import kkt.sai.composetodoapp.entity.OutCome
import kkt.sai.composetodoapp.entity.Task
import java.lang.Exception
import kkt.sai.composetodoapp.entity.OutCome.*

class DefaultRemoteDataSource (val taskService: TaskService) : RemoteDataSource {
    override suspend fun getTasks(): OutCome<List<Task>> {
        return Loading
    }
}