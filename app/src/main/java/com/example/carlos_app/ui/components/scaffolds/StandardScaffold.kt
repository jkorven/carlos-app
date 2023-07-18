package com.example.carlos_app.ui.components.scaffolds

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SheetState
import androidx.compose.material3.SheetValue
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.carlos_app.domain.model.BottomNavBarItem
import com.example.carlos_app.domain.model.BottomSheetParams
import com.example.carlos_app.ui.components.StandardBottomNavBar
import com.example.carlos_app.util.conditional

@ExperimentalMaterial3Api
@Composable
fun StandardScaffold(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    showBottomNavBar: Boolean = true,
    bottomNavBarItems: List<BottomNavBarItem>,
    enableBottomSheet: Boolean = false,
    bottomSheetContnet: @Composable() (ColumnScope.() -> Unit),
    bottomSheetModifier: Modifier = Modifier,
    bottomSheetParams: BottomSheetParams,
    content: @Composable () -> Unit
) {
    val bottomSheetCoroutineScope = rememberCoroutineScope()
    val bottomSheetScaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = SheetState(
            skipPartiallyExpanded = true,
            initialValue = SheetValue.Hidden
        )
    )
    val newParams = BottomSheetParams(
        sheetValue =
    )

    StandardBottomSheetScaffold(
        sheetContent = ,
        modifier = ,
        scaffoldState = ,
        sheetPeekHeight = ,
        sheetShape = BottomSheetDefaults.ExpandedShape,
        sheetContainerColor = ,
        sheetContentColor = ,
        sheetTonalElevation = ,
        sheetShadowElevation = ,
        sheetDragHandle = { /*TODO*/ },
        sheetSwipeEnabled = ,
        topBar = { /*TODO*/ },
        snackbarHost = ,
        containerColor = ,
        contentColor = 
    ) {
        StandardScreenScaffold(
            navController = navController,
            modifier = modifier,
            showBottomNavBar = showBottomNavBar,
            bottomNavBarItems = bottomNavBarItems
        ) {
            content()
        }
    }
}