package com.example.carlos_app.screens.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.carlos_app.R

@Composable
fun Spotlight(id: Int, title: String, imageUrl: String, description: String = "", sticker: String = "") {
    val backgrounds = listOf(
        R.drawable.spotlight_background_blue,
        R.drawable.spotlight_background_green,
        R.drawable.spotlight_background_yellow
    )

    Box(
//        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
    ) {
        Image(
            modifier = Modifier
                .fillMaxSize(),
            painter = painterResource(
                backgrounds[id%backgrounds.size]
            ),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
//                .height(160.dp)
                .padding(PaddingValues(top = 20.dp, bottom = 20.dp))
                .background(Color.White)
        ) {
            AsyncImage(
                modifier = Modifier
                    .fillMaxWidth(),
//                .padding(PaddingValues(top = 20.dp, bottom = 20.dp)),
                model = imageUrl,
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
        }

//        Box(
//            contentAlignment = Alignment.Center,
//            modifier = Modifier
//                .fillMaxWidth()
//                .background(Color.White)
//                .height(160.dp)
//        ) {
//
//
//            Text(
//                text = title.uppercase(),
//                fontSize = MaterialTheme.typography.titleMedium.fontSize,
//                fontWeight = FontWeight.Bold,
//                color = Color.White
//            )
//        }
        Box(
            modifier = Modifier
                .padding(PaddingValues(start = 10.dp, top = 160.dp))
                .background(Color.Blue)
                .height(20.dp)
                .width(20.dp)
        ) {

        }

    }
}