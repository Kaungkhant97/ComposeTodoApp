package kkt.sai.composetodoapp.model.local

import kkt.sai.composetodoapp.entity.Task
import kotlinx.coroutines.flow.Flow

interface LocalDataSource {
    fun getTasks():Flow<List<Task>>
}