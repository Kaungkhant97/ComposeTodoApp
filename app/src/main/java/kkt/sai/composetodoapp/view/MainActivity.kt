package kkt.sai.composetodoapp.view

import android.os.Bundle
import android.widget.LinearLayout
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kkt.sai.composetodoapp.entity.Task
import kkt.sai.composetodoapp.ui.theme.ComposeTodoAppTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val task = Task("a","b",1)

        setContent {
            ComposeTodoAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Greeting("Android")
                    Joking(joke = "Haha")

                }
                
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