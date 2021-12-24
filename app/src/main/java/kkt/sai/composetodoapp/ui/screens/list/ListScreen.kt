package kkt.sai.composetodoapp.ui.screens.list

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kkt.sai.composetodoapp.entity.OutCome
import kkt.sai.composetodoapp.entity.Task
import kkt.sai.composetodoapp.viewmodel.ListViewModel

// ListScreen Top Hierarchy
@ExperimentalMaterialApi
@Composable
fun ListScreen(
    viewModel: ListViewModel,
    navigate: (route:String) -> Unit
) {
    val allTasks by viewModel.allTasks.collectAsState()

    Scaffold(
        topBar = {
            // AppBar Composable TODO
        },
        content = {
            if (allTasks is OutCome.Success) {
                DisplayTasks(tasks = (allTasks as OutCome.Success<List<Task>>).data,navigate)
            }
        },
        floatingActionButton = {
            ListFab(navigate)
        },
        floatingActionButtonPosition = FabPosition.Center,
        bottomBar = {

        },
    )
}


@ExperimentalMaterialApi
@Composable
fun DisplayTasks(tasks: List<Task>, navigate: (route: String) -> Unit) {
    LazyColumn {
        items(tasks, itemContent = {
                item -> TaskItem(task = item,navigate)
        })
    }
}

@ExperimentalMaterialApi
@Composable
fun TaskItem(
    task: Task,
    navigate: (route: String) -> Unit
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth(),
        shape = RectangleShape,
        onClick = {navigate(task.id)}
    ) {
        Column(
            modifier = Modifier
                .padding(all = 3.dp)
                .fillMaxWidth()
        ) {
            Row {
                Text(
                    modifier = Modifier.weight(8f),
                    text = task.title,
                    style = MaterialTheme.typography.h5,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1
                )
            }
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = task.detail,
                style = MaterialTheme.typography.subtitle1,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Composable
fun ListFab(navigate: (route: String) -> Unit) {
    FloatingActionButton(
        onClick = {navigate("")},
        backgroundColor = Color.Blue,
    ) {
        Icon(
            imageVector = Icons.Filled.Add,
            contentDescription = "Add Button",
            tint = Color.White
        )
    }
}

@Preview
@Composable
fun ListScreenPreview() {

}