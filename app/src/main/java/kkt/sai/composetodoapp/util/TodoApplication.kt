package kkt.sai.composetodoapp.util

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import kkt.sai.composetodoapp.BuildConfig

@HiltAndroidApp
class TodoApplication : Application() {
    override fun onCreate() {
        super.onCreate()

    }
}