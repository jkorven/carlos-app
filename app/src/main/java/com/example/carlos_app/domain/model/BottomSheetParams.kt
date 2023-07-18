package com.example.carlos_app.domain.model

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.BottomSheetScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SheetValue
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.contentColorFor
import androidx.compose.material3.toShape
import androidx.compose.material3.tokens.SheetBottomTokens
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@ExperimentalMaterial3Api
@Composable
fun test(): Shape {
    return BottomSheetDefaults.ExpandedShape
}
@ExperimentalMaterial3Api
object BottomSheetParams(
    modifier: Modifier = Modifier,
    sheetValue: SheetValue = SheetValue.Hidden,
    sheetPeekHeight: Dp = 0.dp,
    sheetShape: @Composable (() -> Shape) = test(),
    sheetContainerColor: Color @Composable get() = BottomSheetDefaults.ContainerColor,
    sheetContentColor: Color @Composable get() = contentColorFor(sheetContainerColor),
    sheetTonalElevation: Dp = BottomSheetDefaults.Elevation,
    sheetShadowElevation: Dp = BottomSheetDefaults.Elevation,
    sheetDragHandle: @Composable (() -> Unit)? = null,
    sheetSwipeEnabled: Boolean = false,
    topBar: @Composable (() -> Unit)? = null,
    snackbarHost: @Composable (SnackbarHostState) -> Unit = { SnackbarHost(it) },
    containerColor: Color @Composable get() = MaterialTheme.colorScheme.surface,
    contentColor: Color @Composable get() = contentColorFor(containerColor),
) {
    val modifier: Modifier = Modifier
    val sheetValue: SheetValue = SheetValue.Hidden
    val sheetPeekHeight: Dp = 0.dp
    val sheetShape: Shape @Composable get() = BottomSheetDefaults.ExpandedShape
    val sheetContainerColor: Color @Composable get() = BottomSheetDefaults.ContainerColor
    val sheetContentColor: Color @Composable get() = contentColorFor(sheetContainerColor)
    val sheetTonalElevation: Dp = BottomSheetDefaults.Elevation
    val sheetShadowElevation: Dp = BottomSheetDefaults.Elevation
    val sheetDragHandle: @Composable (() -> Unit)? = null
    val sheetSwipeEnabled: Boolean = false
    val topBar: @Composable (() -> Unit)? = null
    val snackbarHost: @Composable (SnackbarHostState) -> Unit = { SnackbarHost(it) }
    val containerColor: Color @Composable get() = MaterialTheme.colorScheme.surface
    val contentColor: Color @Composable get() = contentColorFor(containerColor)
}