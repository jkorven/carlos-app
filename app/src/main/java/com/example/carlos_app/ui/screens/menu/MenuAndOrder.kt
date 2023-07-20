package com.example.carlos_app.ui.screens.menu

import android.annotation.SuppressLint

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.unit.IntSize
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.carlos_app.local.Local
import com.example.carlos_app.ui.viewmodel.AppViewModel


@SuppressLint("RememberReturnType")
@Composable
fun MenuAndOrderScreen(
    navController: NavHostController
) {
    val viewModel = Local.AppViewModel.current
    MenuAndOrderContent(viewModel = viewModel)
}

@Composable
fun MenuAndOrderContent(
    viewModel: AppViewModel
) {
    val state = viewModel.state.collectAsState()
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
                ),
            contentAlignment = Alignment.Center
        ) {
            Button(onClick = {
                    viewModel.setState(
                        num = state.value.num + 1
                    )
                }
            ) {
                Text(
                    text = state.value.num.toString()
                )
            }
        }
    }
}
