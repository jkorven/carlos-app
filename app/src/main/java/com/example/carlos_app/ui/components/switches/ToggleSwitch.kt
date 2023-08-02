package com.example.carlos_app.ui.components.switches

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ToggleSwitch(
    modifier: Modifier = Modifier,
    labelList: List<String>,
    shape: Shape = RoundedCornerShape(10.dp),
    backgroundColor: Color = MaterialTheme.colors.onPrimary,
    border: BorderStroke? = null
) {

    val labelCount = labelList.size
    Surface(
        modifier = modifier
            .height(40.dp)
            .width(100.dp),
        shape = shape,
        color = backgroundColor,
        border = border
    ) {
        var localHeightSp by remember{ mutableStateOf(0.sp) }

        var localHeightDp by remember { mutableStateOf(0.dp) }
        BoxWithConstraints(
            modifier = Modifier.fillMaxSize().onGloballyPositioned {
                localHeightSp = with(LocalDensity.current) {
                    it.
                }
            }
        ) {
            val localDensity = LocalDensity.current
            val boxHeight = this.maxHeight
            var localHeightSp by remember{ mutableStateOf(0.sp) }
            Column(
                modifier = Modifier
            ) {
                Text(text = localHeightSp.toString())
                Text(text = localHeightDp.toString())
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    labelList.forEach {
                        Text(
                            text = it,
                            fontSize = 12.sp
                        )
                    }
                }
            }
        }

    }
}
