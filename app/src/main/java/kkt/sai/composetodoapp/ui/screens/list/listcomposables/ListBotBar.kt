package kkt.sai.composetodoapp.ui.screens.list.listcomposables

import androidx.compose.foundation.layout.Row
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

// BotBar Top Hierarchy
@Composable
fun ListBotBar() {
    DefaultListBotBar(
        onSearchClicked = { /*TODO*/ },
        onSortClicked = { /*TODO*/ },
        onSettingsClicked = { /*TODO*/ }) {
    }
}

@Composable
fun DefaultListBotBar(
    onSearchClicked: () -> Unit,
    onSortClicked: () -> Unit,
    onSettingsClicked: () -> Unit,
    navigateToProfileScreen: () -> Unit,
) {
    BottomAppBar(
        content = {
            // BotAppBarActions
            /*
            * - onSearchClicked
            * - onProfileClicked
            * - onSortClicked
            * - onSettingsClicked
            */
            ListBotBarActions(
                onSearchClicked = onSearchClicked,
                onSortClicked = { /*TODO*/ },
                onSettingsClicked = { /*TODO*/ }) {

            }
        }
    )
}

@Composable
fun ListBotBarActions(
    onSearchClicked: () -> Unit,
    onSortClicked: () -> Unit,
    onSettingsClicked: () -> Unit,
    navigateToProfileScreen: () -> Unit,
) {
    Row {
        SearchAction(onSearchClicked = onSearchClicked)
        SortAction(onSortClicked = onSortClicked)
        SettingsAction()
        ProfileAction()
    }
}

@Composable
fun SearchAction(onSearchClicked: () -> Unit) {
    IconButton(onClick = { onSearchClicked() }) {
        Icon(
            imageVector = Icons.Filled.Search,
            contentDescription = "Search Tasks",
            tint = Color.White
        )
    }
}

@Composable
fun SortAction(onSortClicked: () -> Unit) {
    IconButton(
        // expand: Bool
        onClick = { onSortClicked() }
    ) {
        Icon(
            imageVector = Icons.Filled.List,
            contentDescription = "Filter Tasks",
            tint = Color.White
        )
        DropdownMenu(
            expanded = true,
            onDismissRequest = { false }
        ) {

        }
    }
}

@Composable
fun SettingsAction() {

}

@Composable
fun ProfileAction() {

}

@Preview
@Composable
fun ListBotBarPreview() {
    ListBotBar()
}