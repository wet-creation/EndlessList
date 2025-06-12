@file:OptIn(ExperimentalMaterial3Api::class)

package ua.com.endlesslist.ui.compoents.scaffold

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import ua.com.endlesslist.ui.theme.Icons

val topAppBarColors
    @Composable
    get() =
        TopAppBarDefaults.topAppBarColors().copy(
            containerColor = Color.Transparent,
            titleContentColor = Color.Transparent,
            scrolledContainerColor = Color.Transparent,
            actionIconContentColor = Color.Transparent,
            navigationIconContentColor = Color.Transparent,
        )

@Composable
fun TopAppBar(
    modifier: Modifier = Modifier,
    startItem: (@Composable () -> Unit)? = null,
    endItem: (@Composable () -> Unit)? = null,
    colors: TopAppBarColors = topAppBarColors,
) {
    CenterAlignedTopAppBar(
        colors = colors,
        modifier = modifier,
        title = {},
        navigationIcon = {
            startItem?.invoke()
        },
        actions = {

            endItem?.invoke()
        }
    )
}


@Preview
@Composable
private fun AgroswitTopAppBarPrev() {
    TopAppBar(
        startItem = {
            Image(
                painter = Icons.infoButton,
                contentDescription = "",
            )
        },
        modifier = Modifier
            .fillMaxWidth(),

        endItem = {
            Image(
                painter = Icons.searchButton,
                contentDescription = ""
            )
        }
    )
}