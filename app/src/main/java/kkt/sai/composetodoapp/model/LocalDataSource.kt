package kkt.sai.composetodoapp.model

import kkt.sai.composetodoapp.entity.Task

interface LocalDataSource {

    fun getTasks():Result<List<Task>>;
}