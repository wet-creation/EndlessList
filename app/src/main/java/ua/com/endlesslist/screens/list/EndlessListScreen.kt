package ua.com.endlesslist.screens.list

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import ua.com.endlesslist.comingSoonToast
import ua.com.endlesslist.ui.compoents.buttons.FilterButton
import ua.com.endlesslist.ui.compoents.containers.ItemContainer
import ua.com.endlesslist.ui.compoents.scaffold.Background
import ua.com.endlesslist.ui.compoents.scaffold.MyScaffold
import ua.com.endlesslist.ui.compoents.scaffold.TopAppBar
import ua.com.endlesslist.ui.theme.Colors
import ua.com.endlesslist.ui.theme.EndlessListTheme
import ua.com.endlesslist.ui.theme.Icons

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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun EndlessListScreen(
    state: EndlessListState,
    onAction: (EndlessListAction) -> Unit,
) {
    val listState = rememberLazyListState()
    val context = LocalContext.current
    LaunchedEffect(listState.canScrollForward) {
        if (state.items.size <= 10_000 && !listState.canScrollForward)
            onAction(EndlessListAction.LoadNext)
    }
    Background {
        MyScaffold(
            topAppBar = {
                TopAppBar(
                    startItem = {
                        IconButton(
                            onClick = {
                                comingSoonToast(context)
                            }
                        ) {
                            Image(
                                modifier = Modifier.size(30.dp),
                                painter = Icons.infoButton,
                                contentDescription = "",
                            )
                        }

                    },
                    modifier = Modifier
                        .fillMaxWidth(),

                    endItem = {
                        IconButton(
                            onClick = {
                                comingSoonToast(context)
                            }
                        ) {
                            Image(
                                modifier = Modifier.size(30.dp),
                                painter = Icons.searchButton,
                                contentDescription = ""
                            )
                        }
                    }
                )
            }
        ) { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(horizontal = 17.dp)

            ) {
                Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
                    Text(
                        "Good morning!",
                        color = Colors.Primary,
                        style = MaterialTheme.typography.titleLarge
                    )
                    Text(
                        "Your daily dose of subliminals is ready",
                        color = Colors.ThirdedText,
                        style = MaterialTheme.typography.titleMedium
                    )
                }
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    modifier = Modifier.padding(top = 19.dp, bottom = 22.dp)
                ) {
                    item {
                        FilterButton(
                            text = "All together",
                            active = true
                        ) { }
                    }
                    item {
                        FilterButton(
                            text = "For women",
                            active = false
                        ) {
                            comingSoonToast(context)

                        }
                    }
                    item {
                        FilterButton(
                            text = "For men",
                            active = false
                        ) {
                            comingSoonToast(context)

                        }
                    }
                    item {
                        FilterButton(
                            text = "Health & Wellness",
                            active = false
                        ) {
                            comingSoonToast(context)
                        }
                    }

                }
                LazyColumn(
                    modifier = Modifier.padding(),
                    state = listState,
                    verticalArrangement = Arrangement.spacedBy(20.dp)
                ) {
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

