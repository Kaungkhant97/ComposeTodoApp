package kkt.sai.composetodoapp.model

import kkt.sai.composetodoapp.entity.Task
import kkt.sai.composetodoapp.model.local.LocalDataSource

class FakeTestLocalDataSource : LocalDataSource {

    override fun getTasks(): Result<List<Task>> {
        TODO("Not yet implemented")
    }
}