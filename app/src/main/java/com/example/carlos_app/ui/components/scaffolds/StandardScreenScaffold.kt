package com.example.carlos_app.ui.components.scaffolds

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomSheetScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.carlos_app.domain.model.BottomNavBarItem
import com.example.carlos_app.ui.components.StandardBottomNavBar
import com.example.carlos_app.util.conditional
import kotlinx.coroutines.CoroutineScope

@ExperimentalMaterial3Api
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun StandardScreenScaffold(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    showBottomNavBar: Boolean = true,
    bottomNavBarItems: List<BottomNavBarItem>,
    bottomSheetScaffoldState: BottomSheetScaffoldState,
    bottomSheetCoroutineScope: CoroutineScope,
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
            if(bottomSheetState != null)  {
                content(
                    bottomSheetState = bottomSheetState
                )
            }  else {
                content()
            }
        }
    }
}