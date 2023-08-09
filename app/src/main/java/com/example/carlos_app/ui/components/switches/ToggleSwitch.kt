package com.example.carlos_app.ui.components.switches

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.carlos_app.domain.model.ToggleOption
import com.example.carlos_app.ui.theme.DarkGray
import com.example.carlos_app.ui.theme.MediumGray


//Explanation of getting sizes. Seems important
//https://stackoverflow.com/questions/73354911/how-to-get-exact-size-without-recomposition/73357119#73357119

@Composable
fun ToggleSwitch(
    modifier: Modifier = Modifier,
    labelList: List<ToggleOption>,
    backgroundColor: Color = MaterialTheme.colors.onPrimary,
    indicatorStart: Int = 0,
    indicatorColor: Color = Color.Blue,
    border: BorderStroke? = BorderStroke(width = 1.dp, color = MediumGray.copy(alpha = 0.5f)),
    elevation: Dp = 0.dp
) {

    val localDensity = LocalDensity.current
    val labelCount = labelList.size
    var localHeightSp by remember{ mutableStateOf(0.sp) }
    var localHeightDp by remember{ mutableStateOf(0.dp) }
    var localWidthDp by remember{ mutableStateOf(0.dp) }

    var indicatorPosition by remember{ mutableIntStateOf(indicatorStart)}
    Surface(
        modifier = modifier
            .height(24.dp)
            .width(50.dp * labelCount)
            .onGloballyPositioned {
                localHeightSp = with(localDensity) {
                    it.size.height.toSp()
                }
                localHeightDp = with(localDensity) {
                    it.size.height.toDp()
                }
                localWidthDp = with(localDensity) {
                    it.size.width.toDp()
                }
            },
        shape = RoundedCornerShape(localHeightDp / 2),
        color = backgroundColor,
        border = border,
        elevation = elevation
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            ToggleIndicator(
                containerHeight = localHeightDp,
                containerWidth = localWidthDp,
                listCount = labelCount,
                color = indicatorColor,
                currentPosition = indicatorPosition
            )
            Row(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                labelList.forEachIndexed {index, it ->
                    Column(
                        modifier = Modifier
                            .fillMaxHeight()
                            .width(localWidthDp / labelCount)
                            .clickable(
                                onClick = {
                                    indicatorPosition = index
                                }
                            ),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = it.title,
                            textAlign = TextAlign.Center,
                            fontSize = localHeightSp * 0.5,
                            fontWeight = if (indicatorPosition == index) {
                                FontWeight.Bold
                            } else FontWeight.Normal,
                            color = if (indicatorPosition == index) {
                                Color.White
                            } else DarkGray
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun ToggleIndicator(
    containerHeight: Dp,
    containerWidth: Dp,
    listCount: Int,
    color: Color,
    currentPosition: Int = 0
) {
    val width = containerWidth / listCount
    Canvas(
        modifier = Modifier
            .height(containerHeight)
            .width(width)
            .absoluteOffset(x = width * currentPosition)
    ) {
        drawRoundRect(
            color = color,
            cornerRadius = CornerRadius(90f, 90f)
        )
    }
}
