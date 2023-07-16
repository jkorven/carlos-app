package com.example.carlos_app.ui.screens

import android.annotation.SuppressLint

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.unit.IntSize
import androidx.navigation.NavController
import androidx.navigation.NavHostController


@SuppressLint("RememberReturnType")
@Composable
fun MenuAndOrderScreen(
    navController: NavHostController
) {
    var size by remember { mutableStateOf(IntSize.Zero)}
    BoxWithConstraints (
        modifier = Modifier
            .fillMaxSize()
            .onGloballyPositioned {
                size = it.size
            }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.White, Color.Gray
                        ),
                        startY = size.height * 0.6f,
                        endY = Float.POSITIVE_INFINITY
                    )
                )
        ) {

        }
    }
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//    ) {
//        Box(
//            modifier = Modifier
//                .fillMaxSize()
//                .weight(1f, false)
//                .background(
//                    brush = Brush.verticalGradient(
//                        colors = listOf(
//                            Color.White, Color.Gray
//                        )
//                    )
//                )
//        ) {
//
//        }
//    }
//    Box(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(
//                brush = Brush.verticalGradient(
//                    colors = listOf(Color.White, Color.Gray)
//                )
//            )
//    ) {
//        Column(
//            modifier = Modifier
//
//        ) {
//            Box(
//                modifier = Modifier
//                    .fillMaxWidth()
//
//                    .padding(bottom = 100.dp)
////                .border(10.dp, Color.Red)
//                    .background(Color.Transparent)
//            )
//            Box(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(100.dp)
//                    .background( Color.Red
////                    brush = Brush.verticalGradient(
////                        colors = listOf(Color.Black, Color.White)
////                    )
//                    )
//            )
//        }


}
