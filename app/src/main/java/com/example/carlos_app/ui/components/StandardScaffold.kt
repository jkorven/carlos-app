package com.example.carlos_app.ui.components

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.carlos_app.domain.model.BottomNavBarItem
import com.example.carlos_app.util.conditional

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun StandardScaffold(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    showBottomNavBar: Boolean = true,
    bottomNavBarItems: List<BottomNavBarItem>,
    content: @Composable () -> Unit
    ) {
    Scaffold(
        modifier = modifier,
        bottomBar = {
            if(showBottomNavBar) {
                StandardBottomNavBar(
                    navController = navController,
                    bottomNavBarItems = bottomNavBarItems
                )
            }
        }
    ) {innerPadding ->
        Box(
            modifier =  Modifier
                .conditional(showBottomNavBar) {
                    padding(
                        PaddingValues(bottom = innerPadding.calculateBottomPadding())
                    )
                }
        ) {
            content()
        }
    }
}