package com.example.carlos_app.ui.screens

import android.annotation.SuppressLint
import android.content.Context

import android.util.TypedValue
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import com.example.carlos_app.R


@SuppressLint("RememberReturnType")
@Composable
fun MenuScreen() {
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
