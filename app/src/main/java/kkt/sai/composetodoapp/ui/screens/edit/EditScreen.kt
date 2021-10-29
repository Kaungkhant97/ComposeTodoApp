package kkt.sai.composetodoapp.ui.screens.edit

import android.widget.DatePicker
import android.widget.EditText
import androidx.compose.foundation.layout.*
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kkt.sai.composetodoapp.entity.Task

@Composable
fun EditScreen (task: Task,isedit:Boolean){

    Column(modifier = Modifier.wrapContentSize()) {
         TextField(value =task.title, onValueChange = {},textStyle = MaterialTheme.typography.h2)
         Spacer(modifier = Modifier.padding(10.dp))
        TextField(value =task.detail, onValueChange = {},modifier = Modifier.defaultMinSize(minHeight = 210.dp),textStyle = MaterialTheme.typography.body1)

    }
}

@Preview
@Composable
fun EditScreenPreview(){
    EditScreen(task = Task("sample title",detail = "sample detail"), isedit =false );
}