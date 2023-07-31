package com.example.carlos_app.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.CompositingStrategy
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.carlos_app.R
import com.example.carlos_app.providers.Local
import com.example.carlos_app.util.Screen

@Composable
fun HomeScreen(
) {
    val viewModel: HomeViewModel = viewModel()
    HomeContent(
        viewModel = viewModel
    )
}
@Composable
fun HomeContent(
    viewModel: HomeViewModel
) {
    val navController = Local.NavController.current
    Box(
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
                .height(480.dp)
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
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(Color.Black.copy(alpha = 0.8f), Color.Transparent)
                        )
                    ),
                horizontalAlignment = Alignment.CenterHorizontally

            ) {
                Spacer(
                    modifier = Modifier.padding(top = 20.dp)
                )
                Image(
                    modifier = Modifier
                        .height(70.dp)
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
                .padding(top = 480.dp)
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
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Color.Red,
                            contentColor = MaterialTheme.colors.onPrimary
                        ),
                        shape = RoundedCornerShape(5.dp),
                        elevation =  ButtonDefaults.elevation(
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
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
                        shape = RoundedCornerShape(5.dp),
                        elevation =  ButtonDefaults.elevation(
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
    }
}

