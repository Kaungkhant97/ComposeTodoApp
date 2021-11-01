package kkt.sai.composetodoapp.di

import android.content.Context
import androidx.room.Room
import kkt.sai.composetodoapp.model.local.ToDoDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kkt.sai.composetodoapp.model.local.DefaultLocalDataSource
import kkt.sai.composetodoapp.model.DefaultTaskRepository
import kkt.sai.composetodoapp.model.local.LocalDataSource
import kkt.sai.composetodoapp.model.TaskRepository
import kkt.sai.composetodoapp.model.network.DefaultRemoteDataSource
import kkt.sai.composetodoapp.model.network.RemoteDataSource
import kkt.sai.composetodoapp.model.network.RetrofitBuilder
import kkt.sai.composetodoapp.model.network.TaskService
import kotlinx.coroutines.Dispatchers
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
        fun provideTasksDao(@ApplicationContext context: Context): ToDoDatabase {
             return Room.databaseBuilder(context.applicationContext
            , ToDoDatabase::class.java,"Tasks.db").build()
        }
        @Singleton
        @Provides
        fun provideTasksRemoteDataSource(taskService: TaskService): RemoteDataSource {
            return DefaultRemoteDataSource(taskService);
        }

        @Singleton
        @Provides
        fun provideTasksLocalDataSource(tododatabase: ToDoDatabase): LocalDataSource {
            return DefaultLocalDataSource(tododatabase.taskDao());
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
