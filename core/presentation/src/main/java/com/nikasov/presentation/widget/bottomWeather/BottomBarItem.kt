package com.nikasov.presentation.widget.bottomWeather

import androidx.compose.animation.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nikasov.presentation.widget.bottomWeather.utils.BottomBarData
import com.nikasov.presentation.widget.bottomWeather.utils.SelectionState

@Composable
fun BottomBarItem(
    item: BottomBarData,
    selectionState: SelectionState,
    modifier: Modifier = Modifier
) {
    Crossfade(
        targetState = selectionState,
        modifier = modifier
    ) { state ->
        val painter = when (state) {
            SelectionState.Selected -> painterResource(item.selectedIcon)
            SelectionState.Unselected -> painterResource(item.unselectedIcon)
        }
        val textColor = when (state) {
            SelectionState.Selected -> Color(0xFF98B8E6)
            SelectionState.Unselected -> Color(0xFFB9B9B9)
        }
        BottomBarItemContent(item.title, painter, textColor)
    }
}

@Composable
fun BottomBarItemContent(
    title: String,
    painter: Painter,
    textColor: Color
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painter,
            contentDescription = title,
            modifier = Modifier
                .size(22.dp)
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = title,
            fontSize = 10.sp,
            color = textColor
        )
    }
}

@Preview
@Composable
fun BottomBarItemPreview() {
    BottomBarItem(
        BottomBarData.Menu,
        SelectionState.Selected
    )
}