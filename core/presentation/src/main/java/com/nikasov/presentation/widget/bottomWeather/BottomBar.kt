package com.nikasov.presentation.widget.bottomWeather

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nikasov.presentation.R
import com.nikasov.presentation.widget.bottomWeather.utils.BottomBarData
import com.nikasov.presentation.widget.bottomWeather.utils.ItemPosition
import com.nikasov.presentation.widget.bottomWeather.utils.calculateState
import com.nikasov.presentation.widget.bottomWeather.utils.noRippleClickable

private val topItemPadding = 34.dp

@Composable
fun BottomBar(
    modifier: Modifier = Modifier
) {
    var selectedItem by remember { mutableStateOf(ItemPosition.Middle) }
    Box(
        modifier = modifier
            .height(97.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.bgr),
            modifier = Modifier
                .align(Alignment.Center)
                .fillMaxWidth(),
            contentDescription = ""
        )
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .align(Alignment.Center)
                .padding(horizontal = 3.dp)

        ) {
            BottomBarItem(
                item = BottomBarData.LiveMap,
                selectionState = ItemPosition.First.calculateState(selectedItem),
                modifier = Modifier
                    .padding(top = topItemPadding)
                    .weight(1f)
                    .noRippleClickable {
                        selectedItem = ItemPosition.First
                    }
            )
            BottomBarItem(
                item = BottomBarData.Alerts,
                selectionState = ItemPosition.Second.calculateState(selectedItem),
                modifier = Modifier
                    .padding(top = topItemPadding)
                    .weight(1f)
                    .noRippleClickable {
                        selectedItem = ItemPosition.Second
                    }
            )
            BottomBarMiddleItem(
                selectionState = ItemPosition.Middle.calculateState(selectedItem),
                modifier = Modifier
                    .weight(1f)
                    .noRippleClickable {
                        selectedItem = ItemPosition.Middle
                    }
            )
            BottomBarItem(
                item = BottomBarData.Favorites,
                selectionState = ItemPosition.Third.calculateState(selectedItem),
                modifier = Modifier
                    .padding(top = topItemPadding)
                    .weight(1f)
                    .noRippleClickable {
                        selectedItem = ItemPosition.Third
                    }
            )
            BottomBarItem(
                item = BottomBarData.Menu,
                selectionState = ItemPosition.Fourth.calculateState(selectedItem),
                modifier = Modifier
                    .padding(top = topItemPadding)
                    .weight(1f)
                    .noRippleClickable {
                        selectedItem = ItemPosition.Fourth
                    }
            )
        }
    }
}

@Preview
@Composable
fun BottomPreview() {
    BottomBar()
}