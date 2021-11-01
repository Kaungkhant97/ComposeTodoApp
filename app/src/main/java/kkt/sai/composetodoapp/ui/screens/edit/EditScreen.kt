package kkt.sai.composetodoapp.ui.screens.edit

import android.widget.DatePicker
import android.widget.EditText
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import kkt.sai.composetodoapp.entity.Task
import kkt.sai.composetodoapp.entity.succeeded
import kkt.sai.composetodoapp.viewmodel.MainViewModel

@Composable
fun EditScreen ( isedit:Boolean, mainViewModel: MainViewModel){
    mainViewModel._items.observe(this,{
        val data = it as Outcome.Success
    })
    Column(modifier = Modifier.wrapContentSize()) {
         TextField(value = mainViewModel.title.value, onValueChange = { mainViewModel.title.value =it.trim().toString()},textStyle = MaterialTheme.typography.h2)
         Spacer(modifier = Modifier.padding(10.dp))
        TextField(value = mainViewModel.description.value, onValueChange = { mainViewModel.description.value =it.trim().toString() },modifier = Modifier
            .defaultMinSize(minHeight = 150.dp)
            .fillMaxWidth(),textStyle = MaterialTheme.typography.body1)
        Spacer(modifier = Modifier.padding(10.dp))
        Button(onClick = { mainViewModel.insertTask() },Modifier.align(Alignment.CenterHorizontally)) {
            Text(text = "Add")
        }

    }
}

@Preview
@Composable
fun EditScreenPreview(){
    val mainViewModel = hiltViewModel<MainViewModel>()
    EditScreen( isedit =false ,mainViewModel);
}