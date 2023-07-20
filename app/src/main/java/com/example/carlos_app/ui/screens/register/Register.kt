package com.example.carlos_app.ui.screens.register

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavHostController
import com.example.carlos_app.providers.Local
import com.example.carlos_app.providers.LocalExp

@ExperimentalMaterial3Api
@Composable
fun RegisterScreen(
) {
    val viewModel = RegisterViewModel()
    RegisterContent(
        viewModel = viewModel
    )
}

@ExperimentalMaterial3Api
@Composable
fun RegisterContent(
    viewModel: RegisterViewModel
) {
    val navController = Local.NavController.current
    val bottomSheetCoroutineScope = Local.BottomSheetCoroutineScope.current
    val bottomSheetScaffoldState = LocalExp.BottomSheetScaffoldState.current
    val state = viewModel.state.collectAsState()
}