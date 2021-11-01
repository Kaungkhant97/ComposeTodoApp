package kkt.sai.composetodoapp.model.local

import kkt.sai.composetodoapp.entity.Task
<<<<<<< HEAD
import java.util.concurrent.Flow

interface LocalDataSource {

    fun getTasks():LiveData<OutCome<List<Task>>>;

    suspend fun insertTask(task: Task);
=======
import kotlinx.coroutines.flow.Flow

interface LocalDataSource {
    fun getTasks():Flow<List<Task>>
>>>>>>> 791055cc9fff7a8325d04ea55851ce07b7f132e4
}