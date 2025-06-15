package ua.com.endlesslist.ui.compoents.scaffold

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import ua.com.endlesslist.ui.compoents.containers.BottomNavBar


@Composable
fun MyScaffold(
    modifier: Modifier = Modifier,
    topAppBar: @Composable () -> Unit = {},
    showBottomBar: Boolean = true,
    content: @Composable (PaddingValues) -> Unit
) {
    Scaffold(
        containerColor = Color.Transparent,
        topBar = topAppBar,
        bottomBar = {
            if (showBottomBar)
                BottomNavBar()
        },
        modifier = modifier
    ) { padding ->
        content(padding)
    }

}