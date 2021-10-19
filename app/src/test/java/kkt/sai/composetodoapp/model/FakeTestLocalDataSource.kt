package kkt.sai.composetodoapp.model

import androidx.lifecycle.LiveData
import kkt.sai.composetodoapp.entity.OutCome
import kkt.sai.composetodoapp.entity.Task
import kkt.sai.composetodoapp.model.local.LocalDataSource

class FakeTestLocalDataSource : LocalDataSource {

    override fun getTasks(): LiveData<OutCome<List<Task>>> {
        TODO("Not yet implemented")
    }
}