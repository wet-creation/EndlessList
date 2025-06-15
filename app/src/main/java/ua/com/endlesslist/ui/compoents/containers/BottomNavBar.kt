package ua.com.endlesslist.ui.compoents.containers


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ua.com.endlesslist.R
import ua.com.endlesslist.comingSoonToast
import ua.com.endlesslist.ui.theme.Colors
import ua.com.endlesslist.ui.theme.Icons

@Composable
fun BottomNavBar(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    Column {
        HorizontalDivider(color = Colors.Container)
        BottomAppBar(
            containerColor = Colors.White,
            contentColor = Colors.Primary,
            contentPadding = PaddingValues(start = 20.dp, end = 20.dp, top = 4.dp)
        ) {
            BottomNavBarItem(
                modifier.weight(1f),
                title = stringResource(R.string.subliminals),
                icon = Icons.headPhones,
                active = true,
                onClick = {

                },
            )
            BottomNavBarItem(
                modifier.weight(1f),
                title = stringResource(R.string.favorites),
                icon = Icons.heart,
                active = false,
                onClick = {
                    comingSoonToast(context)
                },
            )
            BottomNavBarItem(
                modifier.weight(1f),
                title = stringResource(R.string.journal),
                icon = Icons.notes,
                active = false,
                onClick = {
                    comingSoonToast(context)
                },
            )
        }

    }
}

@Composable
private fun BottomNavBarItem(
    modifier: Modifier = Modifier,
    title: String,
    icon: Painter,
    active: Boolean = false,
    onClick: () -> Unit
) {
    Column(
        modifier = modifier
            .clickable(onClick = onClick)
            .padding(8.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp),

        ) {
        Icon(
            modifier = Modifier.size(24.dp),
            tint = if (active) Colors.PrimaryAccentColor else Colors.Primary,
            painter = icon,
            contentDescription = title
        )
        Text(
            text = title,
            style = MaterialTheme.typography.bodySmall,
            textAlign = TextAlign.Center,
            color = if (active) Colors.PrimaryAccentColor else Colors.Primary
        )
    }
}

@Preview
@Composable
private fun BottomNavBarPrev() {
    BottomNavBar()
}