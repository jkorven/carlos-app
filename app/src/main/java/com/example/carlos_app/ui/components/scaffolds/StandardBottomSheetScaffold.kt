package com.example.carlos_app.ui.components.scaffolds

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.BottomSheetScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

// Watch for an explanation (maybe)
// https://www.youtube.com/watch?v=eFJ-vp9LZ9U
@ExperimentalMaterial3Api
@Composable
fun StandardBottomSheetScaffold(
    sheetContent: @Composable() (ColumnScope.() -> Unit),
    modifier: Modifier = Modifier,
    scaffoldState: BottomSheetScaffoldState,
    isFixedHeight: Dp? = null,
    sheetPeekHeight: Dp = 0.dp,
    sheetShape: Shape = BottomSheetDefaults.ExpandedShape,
    sheetContainerColor: Color = BottomSheetDefaults.ContainerColor,
    sheetContentColor: Color = contentColorFor(sheetContainerColor),
    sheetTonalElevation: Dp = BottomSheetDefaults.Elevation,
    sheetShadowElevation: Dp = BottomSheetDefaults.Elevation,
    sheetDragHandle: @Composable (() -> Unit)? = null,
    sheetSwipeEnabled: Boolean = false,
    topBar: @Composable (() -> Unit)? = null,
    snackbarHost: @Composable (SnackbarHostState) -> Unit = { SnackbarHost(it) },
    containerColor: Color = MaterialTheme.colorScheme.surface,
    contentColor: Color = contentColorFor(containerColor),
    content: @Composable (PaddingValues) -> Unit
) {
        BottomSheetScaffold(
            sheetContent = sheetContent,
            modifier = modifier,
            scaffoldState = scaffoldState,
            sheetPeekHeight = isFixedHeight ?: sheetPeekHeight,
            sheetShape = sheetShape,
            sheetContainerColor = sheetContainerColor,
            sheetContentColor = sheetContentColor,
            sheetTonalElevation = sheetTonalElevation,
            sheetShadowElevation = sheetShadowElevation,
            sheetDragHandle = sheetDragHandle,
            sheetSwipeEnabled = sheetSwipeEnabled,
            topBar = topBar,
            snackbarHost = snackbarHost,
            containerColor = containerColor,
            contentColor = contentColor,
            content = content
        )
}

private fun Modifier.nestedScrollIfSheetGesturesEnabled(
    connection: NestedScrollConnection,
    dispatcher: NestedScrollDispatcher? = null,
    sheetGesturesEnabled: Boolean = true
): Modifier {
    return this.let {
        if (sheetGesturesEnabled) {
            it.nestedScroll(connection, dispatcher)
        } else {
            it
        }
    }
}

@Composable
fun BottomSheetContent(){
    Box {

    }
}
