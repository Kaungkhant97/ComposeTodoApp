package kkt.sai.composetodoapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kkt.sai.composetodoapp.R

class TaskListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.task_list_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, TaskListFragment.newInstance())
                .commitNow()
        }
    }
}