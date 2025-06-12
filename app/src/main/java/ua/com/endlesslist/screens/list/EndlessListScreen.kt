package ua.com.endlesslist.screens.list

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import ua.com.endlesslist.ui.compoents.containers.ItemContainer
import ua.com.endlesslist.ui.theme.EndlessListTheme

const val TAG = "EndlessListScreen"

@Composable
fun EndlessListRoot(
    viewModel: EndlessListViewModel = viewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    EndlessListScreen(
        state = state,
        onAction = viewModel::onAction
    )
}

@Composable
fun EndlessListScreen(
    state: EndlessListState,
    onAction: (EndlessListAction) -> Unit,
) {
    val listState = rememberLazyListState()

    LaunchedEffect(listState) {
        if (state.items.size <= 10_000)
            snapshotFlow { listState.layoutInfo.visibleItemsInfo }
                .collect { visibleItems ->
                    val lastVisible = visibleItems.lastOrNull()?.index ?: 0
                    if (lastVisible >= state.items.size - 5) {
                        onAction(EndlessListAction.LoadNext)
                    }
                }
    }
    LazyColumn(modifier = Modifier.padding(), state = listState) {
        items(state.items, key = { it.id }) {
            ItemContainer(
                modifier = Modifier.fillMaxWidth(),
                title = it.title,
                subtitle = it.subtitle,
                image = rememberAsyncImagePainter(it.imageUrl),
                onClick = {
                    onAction(EndlessListAction.NavigateDetail(it.id))
                }
            )
        }
    }
}

@Preview
@Composable
private fun Preview() {
    EndlessListTheme {
        EndlessListScreen(
            state = EndlessListState(),
            onAction = {}
        )
    }
}