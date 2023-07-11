package com.example.carlos_app.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.carlos_app.R

@Composable
fun MenuScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(Color.White, Color.Gray)
                )
            )
    ) {
        Column(
            modifier = Modifier

        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 100.dp)
//                .border(10.dp, Color.Red)
                    .background(Color.Transparent)
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .background( Color.Red
//                    brush = Brush.verticalGradient(
//                        colors = listOf(Color.Black, Color.White)
//                    )
                    )
            )
        }
//    Image(
////        modifier = Modifier
////            .fillMaxSize(),
////        painter = painterResource(R.drawable.background_full_dark60),
////        contentDescription = null,
////        contentScale = ContentScale.Crop
////    )
//        Text(
//            text = "MENU",
//            fontSize = MaterialTheme.typography.titleMedium.fontSize,
//            fontWeight = FontWeight.Bold,
//            color = Color.White
//        )
    }
    // Background color with a gradiant at the bottom

}