package kkt.sai.composetodoapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kkt.sai.composetodoapp.model.DefaultLocalDataSource
import kkt.sai.composetodoapp.model.DefaultTaskRepository
import kkt.sai.composetodoapp.model.network.DefaultRemoteDataSource
import kkt.sai.composetodoapp.model.network.RetrofitBuilder
import kkt.sai.composetodoapp.model.network.TaskService
import kkt.sai.composetodoapp.viewmodel.MainViewModel

class TodoViewModelFactory :ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        return MainViewModel(DefaultTaskRepository(DefaultLocalDataSource(),
            DefaultRemoteDataSource(RetrofitBuilder.taskService))) as T
    }
}