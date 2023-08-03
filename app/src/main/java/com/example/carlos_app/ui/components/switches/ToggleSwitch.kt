package com.example.carlos_app.ui.components.switches

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.carlos_app.ui.theme.DarkGray
import com.example.carlos_app.ui.theme.MediumGray

@Composable
fun ToggleSwitch(
    modifier: Modifier = Modifier,
    labelList: List<String>,
    shape: Shape = RoundedCornerShape(15.dp),
    backgroundColor: Color = MaterialTheme.colors.onPrimary,
    indicatorColor: Color = Color.Blue,
    border: BorderStroke? = BorderStroke(width = 1.dp, color = MediumGray.copy(alpha = 0.5f)),
    elevation: Dp = 0.dp
) {
    val localDensity = LocalDensity.current
    val labelCount = labelList.size
    var localHeightSp by remember{ mutableStateOf(0.sp) }
    var localHeightDp by remember{ mutableStateOf(0.dp) }
    var localWidthDp by remember{ mutableStateOf(0.dp) }
    Surface(
        modifier = modifier
            .height(24.dp)
            .width(150.dp)
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
        shape = shape,
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
                shape = shape
            )
            Row(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                labelList.forEach {
                    Text(
                        text = it,
                        fontSize = localHeightSp * 0.5
                    )
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
    shape: Shape
) {
    Box(
        modifier = Modifier
            .height(containerHeight)
            .width(containerWidth / listCount)
            .background(color = color, shape = shape)
    )
}
