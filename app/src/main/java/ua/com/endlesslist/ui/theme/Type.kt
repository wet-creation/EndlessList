package ua.com.endlesslist.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import ua.com.endlesslist.R

val Typography = Typography(
    bodySmall = TextStyle(
        fontSize = 10.sp,
        fontFamily = FontFamily(Font(R.font.gilroy_medium)),
        fontWeight = FontWeight(500),
    ),
    bodyMedium = TextStyle(
        fontSize = 12.sp,
        fontFamily = FontFamily(Font(R.font.gilroy_regular)),
    ),
    bodyLarge = TextStyle(
        fontSize = 16.sp,
        fontFamily = FontFamily(Font(R.font.gilroy_semibold)),
    ),
    labelMedium = TextStyle(
        fontSize = 12.sp,
        fontFamily = FontFamily(Font(R.font.gilroy_semibold)),
        fontWeight = FontWeight(600),
    ),

    titleLarge = TextStyle(
        fontSize = 34.sp,
        fontFamily = FontFamily(Font(R.font.gilroy_bold)),
        fontWeight = FontWeight(700),
    ),
    titleSmall = TextStyle(
        fontSize = 14.sp,
        fontFamily = FontFamily(Font(R.font.gilroy_medium)),
        fontWeight = FontWeight(500),
    )
)