package kkt.sai.composetodoapp.view

import android.os.Bundle
import android.widget.LinearLayout
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import dagger.hilt.android.AndroidEntryPoint
import kkt.sai.composetodoapp.entity.Task
import kkt.sai.composetodoapp.ui.screens.list.ListScreen
import kkt.sai.composetodoapp.ui.theme.ComposeTodoAppTheme
import kkt.sai.composetodoapp.viewmodel.SaiViewModel

@AndroidEntryPoint
class MainActivity : ComponentActivity() {


    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val task = Task("a","b")

        setContent {
            ComposeTodoAppTheme {
                val viewModel = hiltViewModel<SaiViewModel>()
                // A surface container using the 'background' color from the theme
                ListScreen(viewModel = viewModel)
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!",Modifier.padding(2.dp,2.dp))

}

@Composable
fun Joking(joke:String){
    Card {
        Text(text = joke)

    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeTodoAppTheme {
        Greeting("Android")
    }
}