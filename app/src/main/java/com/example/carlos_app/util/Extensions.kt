package com.example.carlos_app.util

import android.content.res.Resources
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

fun Int.toDP(): Dp = (this/ Resources.getSystem().displayMetrics.density).dp