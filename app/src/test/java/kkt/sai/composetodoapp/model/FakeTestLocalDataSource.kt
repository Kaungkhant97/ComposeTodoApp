package kkt.sai.composetodoapp.model

import kkt.sai.composetodoapp.entity.Task

class FakeTestLocalDataSource : LocalDataSource {

    override fun getTasks(): Result<List<Task>> {
        TODO("Not yet implemented")
    }
}