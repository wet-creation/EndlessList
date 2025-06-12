package ua.com.endlesslist.ui.compoents.containers

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ua.com.endlesslist.R
import ua.com.endlesslist.ui.theme.Colors

@Composable
fun ItemContainer(
    modifier: Modifier = Modifier,
    title: String,
    subtitle: String,
    image: Painter,
    onClick: () -> Unit
) {
    Row(
        modifier = modifier
            .background(Colors.White, RoundedCornerShape(26.dp))
            .clickable(onClick = onClick)
            .padding(top = 19.dp, bottom = 17.dp, start = 19.dp, end = 50.dp),
        horizontalArrangement = Arrangement.spacedBy(
            20.dp,
        ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            image,
            contentScale = ContentScale.FillBounds,
            contentDescription = title,
            modifier = Modifier.size(79.dp).clip(RoundedCornerShape(100.dp))
        )
        Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
            Text(title, color = Colors.Primary, style = MaterialTheme.typography.bodyLarge)
            Text(
                subtitle,
                color = Colors.SecondaryText,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Preview
@Composable
private fun ItemContainerPrev() {
    ItemContainer(
        title = "Female Super Model Subliminal",
        subtitle = "Become physically attractive",
        image = painterResource(R.drawable.ic_launcher_background),
        onClick = {}
    )
} 