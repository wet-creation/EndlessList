package ua.com.endlesslist.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import ua.com.endlesslist.R

object Icons {
    val backButton: Painter
        @Composable
        get() = painterResource(id = R.drawable.back_button)
    val headPhones: Painter
        @Composable
        get() = painterResource(id = R.drawable.headphones)
    val heart: Painter
        @Composable
        get() = painterResource(id = R.drawable.heart)
    val infoButton: Painter
        @Composable
        get() = painterResource(id = R.drawable.info_button)
    val notes: Painter
        @Composable
        get() = painterResource(id = R.drawable.notes)
    val searchButton: Painter
        @Composable
        get() = painterResource(id = R.drawable.search)

}