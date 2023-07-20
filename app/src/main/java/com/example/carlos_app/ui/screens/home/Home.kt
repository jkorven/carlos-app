package com.example.carlos_app.ui.screens.home

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.CompositingStrategy
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.carlos_app.R
import com.example.carlos_app.data.json.Spotlights
import com.example.carlos_app.ui.screens.home.components.Spotlight
import com.example.carlos_app.util.Screen

@SuppressLint("RememberReturnType")
@Composable
fun HomeScreen(
    navController: NavHostController
) {
    val viewModel: HomeViewModel = viewModel()
    HomeContent(
        navController = navController,
        viewModel = viewModel
    )
}
@Composable
fun HomeContent(
    navController: NavHostController,
    viewModel: HomeViewModel
) {
    BoxWithConstraints(
        modifier = Modifier
            .fillMaxSize()
            .onGloballyPositioned {
                viewModel.setSize(it.size)
            }
    ) {
        Image(
            modifier = Modifier
                .fillMaxSize(),
            painter = painterResource(R.drawable.background_full_dark60),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(380.dp)
        ) {
            AsyncImage(
                modifier = Modifier
                    .fillMaxSize()
                    .graphicsLayer(compositingStrategy = CompositingStrategy.Offscreen)
                    .drawWithContent {
                        val colors = listOf(
                            Color.Black,
                            Color.Transparent
                        )
                        drawContent()
                        drawRect(
                            brush = Brush.verticalGradient(
                                colors = colors,
                                startY = viewModel.state.value.size.height * 0.47f,
                                endY = Float.POSITIVE_INFINITY
                            ),
                            blendMode = BlendMode.DstIn
                        )
                    },
                model = "https://carlosokellys.com/images/banners_frontpage/ChickenCrop.jpg",
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(70.dp)
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(Color.Black.copy(alpha = 0.8f), Color.Transparent)
                        )
                    ),
                contentAlignment = Alignment.Center

            ) {
                Image(
                    modifier = Modifier
                        .width(80.dp)
                        .padding(vertical = 15.dp),
                    painter = painterResource(R.drawable.title_with_logo),
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds
                )
            }
        }
        // Buttons
        Box (
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 380.dp)
                .background(Color.Transparent),
            contentAlignment = Alignment.Center
        ) {

            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth(),
                contentPadding = PaddingValues( start = 20.dp, end = 20.dp, bottom = 20.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                item {
                    Button(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp)
                            .padding(vertical = 20.dp),
                        onClick = {
                            navController.navigate(Screen.MenuAndOrderScreen.route)
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
                        shape = RoundedCornerShape(5.dp),
                        elevation =  ButtonDefaults.buttonElevation(
                            defaultElevation = 10.dp,
                            pressedElevation = 15.dp,
                            disabledElevation = 0.dp
                        ),

                        ) {
                        Text(
                            text = "Delivery & Pickup",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                        )
                    }
                }
                item {
                    Button(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp)
                            .padding(vertical = 20.dp),
                        onClick = {
                            navController.navigate(Screen.LocationsScreen.route)
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                        shape = RoundedCornerShape(5.dp),
                        elevation =  ButtonDefaults.buttonElevation(
                            defaultElevation = 10.dp,
                            pressedElevation = 15.dp,
                            disabledElevation = 0.dp
                        ),

                        ) {
                        Text(
                            text = "Nearest Location",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Red
                        )
                    }
                }
            }
        }
        // Sticker
//        Box(
//            modifier = Modifier
//                .padding(top = 280.dp, start = 40.dp)
//                .height(120.dp)
//                .width(120.dp)
//                .background(Color.Transparent),
//            contentAlignment = Alignment.Center
//        ) {
//            Image(
//                painter = painterResource(R.drawable.sticker_20pt),
//                contentDescription = null,
//                contentScale = ContentScale.FillBounds
//            )
//            Row(
//                modifier = Modifier
//                    .rotate(-20f)
//                    .padding(horizontal = 15.dp),
//            ){
//                Text(
//                    text = "Always Served Sizzlin' Hot!",
//                    fontSize = 16.sp,
//                    textAlign = TextAlign.Center,
//                    color = Color.White,
//                    fontWeight = FontWeight.Bold,
//                    lineHeight = 18.sp
//                )
//            }
//
//        }
    }
}

