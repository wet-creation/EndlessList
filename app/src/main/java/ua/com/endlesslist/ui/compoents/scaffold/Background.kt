package ua.com.endlesslist.ui.compoents.scaffold

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Matrix
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.tooling.preview.Preview
import ua.com.endlesslist.ui.theme.Colors

@Composable
fun Background(modifier: Modifier = Modifier, content: @Composable ColumnScope.() -> Unit) {
    Box(
        modifier
            .background(Colors.White)
            .fillMaxSize()
            .drawBehind {
                val width = size.width
                val height = size.height
                val center = Offset(width*0.35f, height*0.17f)

                val ovalWidth = width * 0.77f
                val ovalHeight = height * 0.35f

                val rect = Rect(
                    left = center.x - ovalWidth / 2f,
                    top = center.y - ovalHeight / 2f,
                    right = center.x + ovalWidth / 2f,
                    bottom = center.y + ovalHeight / 2f
                )
                val matrix = Matrix().apply {
                    translate(-240f, 420f)
                    rotateZ(-45f)
                }
                val path = Path().apply {
                    addOval(rect)
                    transform(matrix)
                    close()
                }

                drawPath(
                    path,
                    color = Colors.SecondaryAccentColor
                )
                val path2 = Path().apply {

                    moveTo(width * 0.29f, height * 0.49f)

                    cubicTo(
                        width * 0.59f, height * 0.47f,
                        width * 0.59f, height * 0.47f,
                        width, height * 0.39f
                    )
                    lineTo(width, height * 0.9f)
                    cubicTo(
                        width, height * 0.9f,
                        width * 0.65f, height * 0.9f,
                        width * 0.48f, height * 0.83f,
                    )
                    cubicTo(
                        width * 0.3f, height * 0.77f,
                        width * 0.24f, height * 0.68f,
                        width * 0.19f, height * 0.6f
                    )
                    cubicTo(
                        width * 0.15f, height * 0.5f,
                        width * 0.29f, height * 0.49f,
                        width * 0.29f, height * 0.49f
                    )
                }
                drawPath(
                    path2,
                    color = Colors.SecondaryAccentColor
                )
            }
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            content()
        }
    }
}

@Preview
@Composable
private fun BackgroundPrev() {
    Background {}
}
