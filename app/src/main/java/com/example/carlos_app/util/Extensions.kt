package com.example.carlos_app.util

import android.content.res.Resources
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp

object Ext {
    fun Int.toDP(): Dp = (this/ Resources.getSystem().displayMetrics.density).dp


}
