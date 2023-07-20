package com.example.carlos_app.ui.components.scaffolds

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SheetState
import androidx.compose.material3.SheetValue
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.material3.rememberStandardBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.carlos_app.domain.model.BottomNavBarItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@ExperimentalMaterial3Api
@Composable
fun StandardScaffold(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    showBottomNavBar: Boolean = true,
    bottomNavBarItems: List<BottomNavBarItem>,
    bottomSheetContnet: @Composable (ColumnScope.() -> Unit)? = null,
    content: @Composable () -> Unit
) {


//    StandardBottomSheetScaffold(
//        sheetContent = {
//            BotSheetContent(
//              coroutineScope = bottomSheetCoroutineScope,
//                sheetState = bottomSheetState
//            )
//        },
//        scaffoldState = bottomSheetScaffoldS
//    ) {
        StandardScreenScaffold(
            navController = navController,
            modifier = modifier,
            showBottomNavBar = showBottomNavBar,
            bottomNavBarItems = bottomNavBarItems,
//            bottomSheetScaffoldState = bottomSheetScaffoldState,
//            bottomSheetCoroutineScope = bottomSheetCoroutineScope
        ) {
            content()
        }
//    }
}

@ExperimentalMaterial3Api
@Composable
fun BotSheetContent(
    coroutineScope: CoroutineScope,
    sheetState: SheetState
) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Button(
            modifier = Modifier
                .fillMaxSize(),
            onClick = {
                coroutineScope.launch {
                    if(!sheetState.isVisible) {
                        sheetState.expand()
                    } else {
                        sheetState.hide()
                    }

                }
            }
        ) {
            Text(
                text = "Hello"
            )
        }
    }
}