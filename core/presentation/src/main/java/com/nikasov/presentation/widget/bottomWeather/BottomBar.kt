package com.nikasov.presentation.widget.bottomWeather

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.nikasov.presentation.R
import com.nikasov.presentation.widget.bottomWeather.utils.BottomBarData
import com.nikasov.presentation.widget.bottomWeather.utils.ItemPosition
import com.nikasov.presentation.widget.bottomWeather.utils.calculateState
import com.nikasov.presentation.widget.bottomWeather.utils.noRippleClickable

private val itemSize = Dimension.value(50.dp)

@Composable
fun BottomBar(
    modifier: Modifier = Modifier
) {
    var selectedItem by remember { mutableStateOf(ItemPosition.Middle) }

    ConstraintLayout(
        modifier = modifier
    ) {
        val (first, second, third, fourth, middle, indicator) = createRefs()
        val topGuideline = createGuidelineFromTop(32.dp)
        Image(painter = painterResource(id = R.drawable.bgr), contentDescription = "")
        BottomBarMiddleItem(
            selectionState = ItemPosition.Middle.calculateState(selectedItem),
            modifier = Modifier
                .constrainAs(middle) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                }
                .padding(horizontal = 10.dp)
                .noRippleClickable {
                    selectedItem = ItemPosition.Middle
                }
        )
        BottomBarItem(
            item = BottomBarData.LiveMap,
            selectionState = ItemPosition.First.calculateState(selectedItem),
            modifier = Modifier
                .constrainAs(first) {
                    top.linkTo(topGuideline)
                    width = Dimension.fillToConstraints
                    height = itemSize
                }
                .noRippleClickable {
                    selectedItem = ItemPosition.First
                }
        )
        BottomBarItem(
            item = BottomBarData.Alerts,
            selectionState = ItemPosition.Second.calculateState(selectedItem),
            modifier = Modifier
                .constrainAs(second) {
                    top.linkTo(topGuideline)
                    width = Dimension.fillToConstraints
                    height = itemSize
                }
                .noRippleClickable {
                    selectedItem = ItemPosition.Second
                }
        )
        BottomBarItem(
            item = BottomBarData.Favorites,
            selectionState = ItemPosition.Third.calculateState(selectedItem),
            modifier = Modifier
                .constrainAs(third) {
                    top.linkTo(topGuideline)
                    width = Dimension.fillToConstraints
                    height = itemSize
                }
                .noRippleClickable {
                    selectedItem = ItemPosition.Third
                }
        )
        BottomBarItem(
            item = BottomBarData.Menu,
            selectionState = ItemPosition.Fourth.calculateState(selectedItem),
            modifier = Modifier
                .constrainAs(fourth) {
                    top.linkTo(topGuideline)
                    width = Dimension.fillToConstraints
                    height = itemSize
                }
                .noRippleClickable {
                    selectedItem = ItemPosition.Fourth
                }
        )
        val currentSelectionRef = when (selectedItem) {
            ItemPosition.First -> first
            ItemPosition.Second -> second
            ItemPosition.Third -> third
            ItemPosition.Fourth -> fourth
            ItemPosition.Middle -> middle
        }
        if (currentSelectionRef != middle) {
            BottomBarIndicator(
                modifier = Modifier
                    .constrainAs(indicator) {
                        start.linkTo(currentSelectionRef.start)
                        end.linkTo(currentSelectionRef.end)
                        bottom.linkTo(parent.bottom)
                    }
            )
        }
        createHorizontalChain(first, second, middle, third, fourth, chainStyle = ChainStyle.Spread)
    }
}

@Preview
@Composable
fun BottomPreview() {
    BottomBar()
}