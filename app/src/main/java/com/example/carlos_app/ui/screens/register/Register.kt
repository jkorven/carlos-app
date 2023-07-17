package com.example.carlos_app.ui.screens.register

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavHostController

@Composable
fun RegisterScreen(
    navController: NavHostController
) {
    val viewModel = RegisterViewModel()
    RegisterContent(
        navController = navController,
        viewModel = viewModel
    )
}

@Composable
fun RegisterContent(
    navController: NavHostController,
    viewModel: RegisterViewModel
) {
    val state = viewModel.state.collectAsState()
}