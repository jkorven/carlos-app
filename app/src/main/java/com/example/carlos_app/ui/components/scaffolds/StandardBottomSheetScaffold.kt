package com.example.carlos_app.ui.components.scaffolds

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.BottomSheetScaffold
import androidx.compose.material.BottomSheetScaffoldDefaults
import androidx.compose.material.BottomSheetScaffoldState
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material.SnackbarHost
import androidx.compose.material.SnackbarHostState
import androidx.compose.material.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@ExperimentalMaterialApi
@ExperimentalMaterial3Api
@Composable
fun StandardBottomSheetScaffold(
    sheetContent: @Composable() (ColumnScope.() -> Unit),
    modifier: Modifier = Modifier,
    scaffoldState: BottomSheetScaffoldState,
    sheetPeekHeight: Dp = 0.dp,
    sheetShape: Shape = MaterialTheme.shapes.large,
    sheetBackgroundColor: Color = MaterialTheme.colorScheme.surface,
    sheetContentColor: Color = contentColorFor(sheetBackgroundColor),
    sheetElevation: Dp = BottomSheetScaffoldDefaults.SheetElevation,
    sheetGesturesEnabled: Boolean = false,
    topBar: @Composable (() -> Unit)? = null,
    snackbarHost: @Composable (SnackbarHostState) -> Unit = { SnackbarHost(it) },
    backgroundColor: Color = MaterialTheme.colorScheme.background,
    contentColor: Color = contentColorFor(backgroundColor),
    content: @Composable (PaddingValues) -> Unit
) {
        BottomSheetScaffold(
            sheetContent = sheetContent,
            modifier = modifier,
            scaffoldState = scaffoldState,
            sheetPeekHeight = sheetPeekHeight,
            sheetShape = sheetShape,
            sheetBackgroundColor = sheetBackgroundColor,
            sheetContentColor = sheetContentColor,
            sheetElevation = sheetElevation,
            sheetGesturesEnabled = sheetGesturesEnabled,
            topBar = topBar,
            snackbarHost = snackbarHost,
            contentColor = contentColor,
            backgroundColor = backgroundColor,
            content = content
        )
}
