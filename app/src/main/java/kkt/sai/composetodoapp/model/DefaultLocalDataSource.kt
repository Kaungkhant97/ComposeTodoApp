package kkt.sai.composetodoapp.model

import kkt.sai.composetodoapp.entity.Task

class DefaultLocalDataSource : LocalDataSource{

    override fun getTasks(): Result<List<Task>> {

        val sampleData = ArrayList<Task>();
        sampleData.add(Task("gg","detail",1));

        return Result.success(sampleData);

    }
}