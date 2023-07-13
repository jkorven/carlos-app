package com.example.carlos_app

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun CarlosApp() {
    val navController: NavHostController = rememberNavController()
    var useScaffold by remember { mutableStateOf(false) }
    val bottomSheetCoroutineScope = rememberCoroutineScope()

    MainScreen()
}

