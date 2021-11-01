package kkt.sai.composetodoapp.model

import kkt.sai.composetodoapp.entity.Task
import kkt.sai.composetodoapp.model.local.LocalDataSource
import kotlinx.coroutines.flow.Flow

class FakeTestLocalDataSource : LocalDataSource {
    override fun getTasks(): Flow<List<Task>> {
        TODO("Not yet implemented")
    }

}