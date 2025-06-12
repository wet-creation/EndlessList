package ua.com.endlesslist.screens.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ua.com.endlesslist.R
import ua.com.endlesslist.ui.compoents.scaffold.MyScaffold
import ua.com.endlesslist.ui.compoents.scaffold.TopAppBar
import ua.com.endlesslist.ui.theme.Colors
import ua.com.endlesslist.ui.theme.EndlessListTheme
import ua.com.endlesslist.ui.theme.Icons


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(
    title: String,
    onBack: () -> Unit
) {

    MyScaffold(
        showBottomBar = false,
        topAppBar = {
            TopAppBar(
                startItem = {
                    IconButton(
                        onClick = {
                            onBack()
                        }
                    ) {
                        Image(
                            modifier = Modifier.size(30.dp),
                            painter = Icons.backButton,
                            contentDescription = stringResource(R.string.back_button),
                        )
                    }

                },
                modifier = Modifier
                    .fillMaxWidth(),

                )
        }
    ) { _ ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Colors.White)
                .padding(horizontal = 56.dp)
        ) {
            Text(
                title,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleLarge,
                color = Colors.Primary,
                modifier = Modifier.align(
                    Alignment.Center
                )
            )
        }
    }
}

@Preview
@Composable
private fun DetailScreenPreview() {
    EndlessListTheme {
        DetailScreen(
            "Hello"
        ) {}
    }
}