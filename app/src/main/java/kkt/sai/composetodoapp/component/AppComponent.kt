package kkt.sai.composetodoapp.component

import kkt.sai.composetodoapp.model.DefaultLocalDataSource
import kkt.sai.composetodoapp.model.LocalDataSource

class AppComponent {

    fun getLocalDataSource():LocalDataSource{

        return DefaultLocalDataSource();
    }
}