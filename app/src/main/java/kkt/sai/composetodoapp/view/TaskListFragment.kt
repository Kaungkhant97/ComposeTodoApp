package kkt.sai.composetodoapp.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import kkt.sai.composetodoapp.R
import kkt.sai.composetodoapp.TodoViewModelFactory
import kkt.sai.composetodoapp.model.TaskRepository
import kkt.sai.composetodoapp.viewmodel.MainViewModel


class TaskListFragment : Fragment() {

    companion object {
        fun newInstance() = TaskListFragment()
    }


    private var textView: TextView? = null;
    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val currentView =  inflater.inflate(R.layout.main_fragment, container, false)
        textView =  currentView?.findViewById<TextView>(R.id.message);


        return currentView;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        val factory = TodoViewModelFactory();
        viewModel = ViewModelProvider(this,factory).get(MainViewModel::class.java)


        activity?.let {
            viewModel._items.observe(it, Observer {
              it.onSuccess {
                  textView?.text = it.get(0).title;

              }
            })
        }


    }

}