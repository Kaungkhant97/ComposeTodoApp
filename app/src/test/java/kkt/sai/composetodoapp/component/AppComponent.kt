package kkt.sai.composetodoapp.component

import kkt.sai.composetodoapp.model.FakeTestLocalDataSource
import kkt.sai.composetodoapp.model.local.LocalDataSource

class AppComponent {

    fun getLocalDataSource(): LocalDataSource {

        return FakeTestLocalDataSource();
    }
}