package kkt.sai.composetodoapp.ui.screens.detail

import android.app.Dialog
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import kkt.sai.composetodoapp.entity.Task

@Composable
fun DetailScafold(

){
    val materialBlue700= Color(0xFF1976D2)
    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Open))
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = { TopAppBar(title = {Text("TopAppBar")},backgroundColor = materialBlue700)  },
        floatingActionButtonPosition = FabPosition.End,
        floatingActionButton = { FloatingActionButton(onClick = {}){
            Text("X")
        } },
        drawerContent = { Text(text = "drawerContent") },
        content = { Text("BodyContent") },
        bottomBar = { BottomAppBar(backgroundColor = materialBlue700) { Text("BottomAppBar") } }
    )
}


//    Column(modifier =Modifier.fillMaxSize()) {
//        Text(text = "title",fontSize= 80.sp)
//        Text(text = "Detail")
//    }
@Composable
fun AlertDialogSample() {

    MaterialTheme {
        Column {
            val openDialog = remember { mutableStateOf(false)  }
            val task = remember { mutableStateOf(Task())}
            Button(onClick = {
                openDialog.value = true
            }) {
                Text("Click me")
            }

            DetailDialog(openDialog)
        }

    }
}

@Composable
fun DetailDialog(open:MutableState<Boolean> ){
    if(open.value) {
        Dialog(onDismissRequest = { /*TODO*/ }) {
            SampleTaskDetail(open)

        }
    }
}
@Composable
fun SampleTaskDetail(dismiss :MutableState<Boolean>){
    Card(modifier = Modifier.wrapContentSize()) {
        Column() {
            Text(text = "Sample Title")
            Text(text = "Detail")
            Button(onClick = { dismiss.value =false}){
                Text(text = "Click")

            }
        }
    }

}


@Composable
@Preview
fun previewDetail(){

    val state = mutableStateOf(false);
    SampleTaskDetail(state);
}