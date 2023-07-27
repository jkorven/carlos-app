package com.example.carlos_app.util

import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher
import androidx.compose.ui.input.nestedscroll.nestedScroll

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