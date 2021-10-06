package kkt.sai.composetodoapp.model

import kkt.sai.composetodoapp.entity.OutCome
import kkt.sai.composetodoapp.entity.Task

class DefaultLocalDataSource : LocalDataSource{

    override fun getTasks(): OutCome<List<Task>> {

        val sampleData = ArrayList<Task>();
        sampleData.add(Task("gg","detail",1));

        return OutCome.Success(sampleData);

    }
}