package kkt.sai.composetodoapp.model

import kkt.sai.composetodoapp.entity.OutCome
import kkt.sai.composetodoapp.entity.Task

interface LocalDataSource {

    fun getTasks():OutCome<List<Task>>;
}