package kkt.sai.composetodoapp.model.local

import androidx.lifecycle.LiveData
import kkt.sai.composetodoapp.entity.OutCome
import kkt.sai.composetodoapp.entity.Task
import java.util.concurrent.Flow

interface LocalDataSource {

    fun getTasks():LiveData<OutCome<List<Task>>>;

    suspend fun insertTask(task: Task);
}