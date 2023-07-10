package com.example.carlos_app.screens.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.carlos_app.R

@Composable
fun Spotlight(id: Int, title: String, imageUrl: String, description: String = "", sticker: String = "") {
    val backgrounds = listOf(
        R.drawable.spotlight_background_orange,
        R.drawable.spotlight_background_green,
        R.drawable.spotlight_background_blue
    )
    fun DivideRemainder() {

    }
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Magenta)
            .height(200.dp)
    ) {
        Image(
            modifier = Modifier
                .fillMaxSize(),
            painter = painterResource(
                fun(id): Int {
                    val index =
                }
            )
        )
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Red)
                .height(160.dp)
        ) {
            Text(
                text = title.uppercase(),
                fontSize = MaterialTheme.typography.titleMedium.fontSize,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }

    }
}