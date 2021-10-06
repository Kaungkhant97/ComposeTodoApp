package kkt.sai.composetodoapp.model.local

import androidx.lifecycle.LiveData
import kkt.sai.composetodoapp.entity.OutCome
import kkt.sai.composetodoapp.entity.Task

interface LocalDataSource {

    fun getTasks():LiveData<OutCome<List<Task>>>;
}