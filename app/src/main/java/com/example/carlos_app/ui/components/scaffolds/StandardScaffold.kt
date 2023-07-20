package com.example.carlos_app.ui.components.scaffolds

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.BottomSheetScaffoldState
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SheetState
import androidx.compose.material3.SheetValue
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.carlos_app.domain.model.BottomNavBarItem
import com.example.carlos_app.providers.Local
import com.example.carlos_app.providers.LocalExp
import com.example.carlos_app.ui.navigation.BottomSheetMap
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
    val navBackStackEntry = Local.NavBackStackEntry.current
    val bottomSheetScaffoldState = LocalExp.BottomSheetScaffoldState.current
    val sheetContent: Unit = BottomSheetMap(
        currentRoute = navBackStackEntry?.destination?.route,
        bottomSheetScaffoldState = bottomSheetScaffoldState
    )
    StandardBottomSheetScaffold(
        sheetContent = {
            sheetContent
        },
        scaffoldState = bottomSheetScaffoldState
    ) {
        StandardScreenScaffold(
            navController = navController,
            modifier = modifier,
            showBottomNavBar = showBottomNavBar,
            bottomNavBarItems = bottomNavBarItems,
        ) {
            content()
        }
    }
}

@ExperimentalMaterial3Api
@Composable
fun BotSheetContent(
    bottomSheetScaffoldState: BottomSheetScaffoldState
) {
    val scope = rememberCoroutineScope()

    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Box(
            contentAlignment = Alignment.Center
        ) {
            Button(
                modifier = Modifier
                    .height(100.dp)
                    .width(200.dp),
                onClick = {
                    scope.launch {
                        bottomSheetScaffoldState.bottomSheetState.hide()
                    }
                }
            ) {
                Text(
                    text = "Hello"
                )
            }
        }


    }
}