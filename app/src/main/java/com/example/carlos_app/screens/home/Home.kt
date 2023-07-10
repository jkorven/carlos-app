package com.example.carlos_app.screens.home

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.carlos_app.R
import com.example.carlos_app.data.json.Spotlights
import com.example.carlos_app.screens.home.components.Spotlight

@Composable
fun HomeScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
//        // Background image
        Image(
            modifier = Modifier
                .fillMaxSize(),
            painter = painterResource(R.drawable.background_full_dark60),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Box(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxSize()
                .background(Color.Transparent)
        ) {
            // Title box
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Transparent)
                    .height(100.dp)
            ) {
                Column (
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    //Title
                    Text(
                        text = "Carlos O'Kelly's",
                        fontSize = 32.sp,
                        fontWeight = FontWeight.Black,
                        color = Color.White,
                        fontFamily = FontFamily.Monospace,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                    )
                    //Subtitle
                    Text(
                        text = "Inspired Mex",
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        fontFamily = FontFamily.Cursive,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                    )
                }
            }
            LazyColumn(
                modifier = Modifier
                    .padding(PaddingValues(top = 100.dp))
            ) {
                //Spotlight items
                val spotlights = Spotlights().splotlights
                val len = spotlights.size
                // Creates a Spotlight for each item in list
                items(len) {
                    val currentSpotlight = spotlights[it]
                    Spotlight(
                        title = currentSpotlight.title,
                        imageUrl = currentSpotlight.image,
                        description = currentSpotlight.description
                    )
                    Spacer(modifier = Modifier.size(16.dp))
                }
            }

        }
    }
}

