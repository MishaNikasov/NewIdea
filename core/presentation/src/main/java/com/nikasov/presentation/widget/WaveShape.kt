package com.nikasov.presentation.widget

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.geometry.RoundRect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.RenderVectorGroup
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.vectorResource
import com.nikasov.presentation.R

@Composable
fun WaveShape(
    tint: Color,
    alpha: Float,
    modifier: Modifier = Modifier
) {

    val vector = ImageVector.vectorResource(id = R.drawable.ic_wave_top)

    val painter = rememberVectorPainter(
        defaultWidth = vector.defaultWidth,
        defaultHeight = vector.defaultHeight,
        viewportWidth = vector.viewportWidth,
        viewportHeight = vector.viewportHeight,
        name = vector.name,
        tintColor = tint,
        tintBlendMode = vector.tintBlendMode,
        autoMirror = vector.autoMirror,
        content = { _, _ -> RenderVectorGroup(group = vector.root) }
    )

    val painterHeight = painter.intrinsicSize.height
    val painterWidth = painter.intrinsicSize.width

    val cornerRadius = 45f

    Canvas(
        modifier = modifier
            .fillMaxSize()
            .alpha(alpha),
        onDraw = {
            val start = size.width / 2 - painterWidth / 2
            val path = Path().apply {
                addRoundRect(
                    RoundRect(
                        left = 0f,
                        top = painterHeight,
                        right = size.width,
                        bottom = size.height,
                        radiusX = cornerRadius,
                        radiusY = cornerRadius
                    )
                )
                close()
            }
            drawPath(
                path,
                tint
            )

            translate(
                left = start
            ) {
                with(painter) {
                    draw(painter.intrinsicSize)
                }
            }
        }
    )
}