package kkt.sai.composetodoapp.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import kkt.sai.composetodoapp.entity.Task
import kkt.sai.composetodoapp.ui.screens.detail.AlertDialogSample
import kkt.sai.composetodoapp.ui.screens.edit.EditScreen
import kkt.sai.composetodoapp.ui.screens.list.ListScreen
import kkt.sai.composetodoapp.view.theme.ComposeTodoAppTheme
import kkt.sai.composetodoapp.viewmodel.ListViewModel
import kkt.sai.composetodoapp.viewmodel.MainViewModel

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val task = Task("a","b")

        setContent {
            ComposeTodoAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {

                    NavigationComponent()


                }
                
            }
        }
    }
}

@ExperimentalMaterialApi
@Composable
fun NavigationComponent(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "list"){

        composable("list"){
            val listViewModel = hiltViewModel<ListViewModel>();
            ListScreen(viewModel = listViewModel);
        }
        composable("edit"){
            val mainViewModel = hiltViewModel<MainViewModel>()
            EditScreen(  mainViewModel =mainViewModel,isedit = false )
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