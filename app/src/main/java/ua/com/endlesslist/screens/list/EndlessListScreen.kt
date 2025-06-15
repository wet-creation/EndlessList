package ua.com.endlesslist.screens.list

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
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
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import ua.com.endlesslist.R
import ua.com.endlesslist.comingSoonToast
import ua.com.endlesslist.ui.compoents.buttons.FilterButton
import ua.com.endlesslist.ui.compoents.containers.ItemContainer
import ua.com.endlesslist.ui.compoents.scaffold.Background
import ua.com.endlesslist.ui.compoents.scaffold.MyScaffold
import ua.com.endlesslist.ui.compoents.scaffold.TopAppBar
import ua.com.endlesslist.ui.theme.Colors
import ua.com.endlesslist.ui.theme.EndlessListTheme
import ua.com.endlesslist.ui.theme.Icons

@Composable
fun EndlessListRoot(
    viewModel: EndlessListViewModel = viewModel(),
    navigateDetail: (String) -> Unit,
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    EndlessListScreen(
        state = state,
        onAction = {
            viewModel.onAction(it)
            when (it) {
                is EndlessListAction.NavigateDetail -> navigateDetail(it.title)
                else -> Unit
            }
        }
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
    val horizontalPadding = 17.dp

    var lastScrollOffset by remember { mutableIntStateOf(0) }
    val showHeader by remember {
        derivedStateOf {
            val index = listState.firstVisibleItemIndex
            if (index < lastScrollOffset) {
                lastScrollOffset = index
                return@derivedStateOf true
            } else if (listState.firstVisibleItemIndex > 3) {
                lastScrollOffset = index
                return@derivedStateOf false
            }
            true

        }
    }

    val topBarOffset by animateDpAsState(
        if (showHeader) 0.dp else (-20).dp, label = "TopBarOffset"
    )
    val headerHeight by animateDpAsState(
        if (showHeader) 225.dp else 0.dp,
        label = "HeaderHeight"
    )

    LaunchedEffect(listState.canScrollForward) {
        if (state.items.size <= 10_000 && !listState.canScrollForward)
            onAction(EndlessListAction.LoadNext)
    }
    Background {
        MyScaffold { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .animateContentSize()
                    .padding(bottom = innerPadding.calculateBottomPadding())
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(headerHeight)
                ) {
                    if (showHeader)
                        Column(
                            Modifier
                                .offset(y = topBarOffset),
                        ) {
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
                                            contentDescription = stringResource(R.string.info_button),
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
                                            contentDescription = stringResource(R.string.search_button)
                                        )
                                    }
                                }
                            )
                            Column(
                                verticalArrangement = Arrangement.spacedBy(2.dp),
                                modifier = Modifier.padding(horizontal = horizontalPadding)
                            ) {
                                Text(
                                    stringResource(R.string.good_morning),
                                    color = Colors.Primary,
                                    style = MaterialTheme.typography.titleLarge
                                )
                                Text(
                                    stringResource(R.string.subtitle_text),
                                    color = Colors.ThirdedText,
                                    style = MaterialTheme.typography.titleSmall
                                )
                            }
                            LazyRow(
                                contentPadding = PaddingValues(horizontal = horizontalPadding),
                                horizontalArrangement = Arrangement.spacedBy(12.dp),
                                modifier = Modifier.padding(top = 19.dp, bottom = 2.dp)
                            ) {
                                item {
                                    FilterButton(
                                        text = stringResource(R.string.all_together),
                                        active = true
                                    ) { }
                                }
                                item {
                                    FilterButton(
                                        text = stringResource(R.string.for_women),
                                        active = false
                                    ) {
                                        comingSoonToast(context)

                                    }
                                }
                                item {
                                    FilterButton(
                                        text = stringResource(R.string.for_men),
                                        active = false
                                    ) {
                                        comingSoonToast(context)

                                    }
                                }
                                item {
                                    FilterButton(
                                        text = stringResource(R.string.health_n_wellness),
                                        active = false
                                    ) {
                                        comingSoonToast(context)
                                    }
                                }

                            }
                        }
                }
                LazyColumn(
                    modifier = Modifier.padding(horizontal = horizontalPadding),
                    state = listState,
                    verticalArrangement = Arrangement.spacedBy(20.dp),
                    contentPadding = PaddingValues(top = 20.dp, bottom = 20.dp),
                ) {
                    items(state.items, key = { it.id }) {
                        ItemContainer(
                            modifier = Modifier.fillMaxWidth(),
                            title = it.title,
                            subtitle = it.subtitle,
                            image = rememberAsyncImagePainter(it.imageUrl),
                            onClick = {
                                onAction(EndlessListAction.NavigateDetail(it.title))
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

