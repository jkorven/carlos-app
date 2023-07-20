package com.example.carlos_app.ui.screens.locations

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import com.example.carlos_app.providers.Local
import com.example.carlos_app.ui.viewmodel.AppViewModel

@Composable
fun LocationsScreen(
) {
    val viewModel = Local.AppViewModel.current
    LocationsContent(viewModel = viewModel)
}
@Composable
fun LocationsContent(
    viewModel: AppViewModel
) {
    val navController = Local.NavController.current
    val state = viewModel.state.collectAsState()
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Text(
            text = "LOCATIONS",
            fontSize = MaterialTheme.typography.titleMedium.fontSize,
            fontWeight = FontWeight.Bold,
            color = Color.Red
        )
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