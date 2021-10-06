package kkt.sai.composetodoapp.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kkt.sai.composetodoapp.model.DefaultLocalDataSource
import kkt.sai.composetodoapp.model.DefaultTaskRepository
import kkt.sai.composetodoapp.model.LocalDataSource
import kkt.sai.composetodoapp.model.TaskRepository
import kkt.sai.composetodoapp.model.network.DefaultRemoteDataSource
import kkt.sai.composetodoapp.model.network.RemoteDataSource
import kkt.sai.composetodoapp.model.network.RetrofitBuilder
import kkt.sai.composetodoapp.model.network.TaskService
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Qualifier
import javax.inject.Singleton




    @Module
    @InstallIn(SingletonComponent::class)
    object AppModule {


        @Singleton
        @Provides
        fun provideTaskService():TaskService{
            return RetrofitBuilder.taskService;
        }

        @Singleton
        @Provides
        fun provideTasksRemoteDataSource(taskService: TaskService): RemoteDataSource {
            return DefaultRemoteDataSource(taskService);
        }

        @Singleton
        @Provides
        fun provideTasksLocalDataSource(): LocalDataSource {
            return DefaultLocalDataSource();
        }



        @Singleton
        @Provides
        fun provideIoDispatcher() = Dispatchers.IO
    }

    /**
     * The binding for TasksRepository is on its own module so that we can replace it easily in tests.
     */
    @Module
    @InstallIn(SingletonComponent::class)
    object TasksRepositoryModule {

        @Singleton
        @Provides
        fun provideTasksRepository(
            remoteTasksDataSource: RemoteDataSource,
            localTasksDataSource: LocalDataSource,
        ): TaskRepository {
            return DefaultTaskRepository(
                 localTasksDataSource, remoteTasksDataSource
            )
        }
    }
