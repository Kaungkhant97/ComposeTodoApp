package kkt.sai.composetodoapp.ui.screens.edit

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kkt.sai.composetodoapp.viewmodel.MainViewModel

@Composable
fun EditScreen ( taskId:String?, mainViewModel: MainViewModel){
    mainViewModel.getTaskDetail(taskId);

    Column(modifier = Modifier.wrapContentSize()) {
         TextField(value = mainViewModel.title.value, onValueChange = { mainViewModel.title.value =it.trim().toString()},textStyle = MaterialTheme.typography.h2)
         Spacer(modifier = Modifier.padding(10.dp))
        TextField(value = mainViewModel.detail.value, onValueChange = { mainViewModel.detail.value =it.trim().toString() },modifier = Modifier
            .defaultMinSize(minHeight = 150.dp)
            .fillMaxWidth(),textStyle = MaterialTheme.typography.body1)
        Spacer(modifier = Modifier.padding(10.dp))
        Button(onClick = { mainViewModel.updateTask() },Modifier.align(Alignment.CenterHorizontally)) {
            Text(text = "Add")
        }

    }
}

@Preview
@Composable
fun EditScreenPreview(){
//    val mainViewModel = hiltViewModel<MainViewModel>()
//    EditScreen( isedit =false ,mainViewModel);
}