package ua.com.endlesslist.ui.compoents.buttons

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ua.com.endlesslist.ui.theme.Colors

@Composable
fun FilterButton(
    modifier: Modifier = Modifier,
    text: String,
    active: Boolean = false,
    onClick: () -> Unit
) {
    Box(
        modifier
            .background(
                color = if (active) Colors.Primary else Colors.Secondary,
                shape = RoundedCornerShape(7.dp)
            )
            .clickable(onClick = onClick)
            .padding(vertical = 10.dp, horizontal = 16.dp)
    ) {
        Text(
            text = text,
            color = if (active) Colors.White else Colors.SecondaryText,
            style = MaterialTheme.typography.labelMedium
        )
    }
}

@Preview
@Composable
private fun FilterButtonPrev() {
    Column {
        FilterButton(
            text = "All together",
            active = true
        ) {

        }
        FilterButton(
            text = "All together",
            active = false
        ) {

        }
    }

}