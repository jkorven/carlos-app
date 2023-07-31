package com.example.carlos_app.util

import androidx.compose.foundation.background
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

object CustomModifiers {
    fun Modifier.conditional(condition : Boolean, modifier : Modifier.() -> Modifier) : Modifier {
        return if (condition) {
            then(modifier(Modifier))
        } else {
            this
        }
    }

    fun Modifier.backgroundGradiant(
        start: Float,
        colors: List<Color>
    ) = this.background(
        brush = Brush.verticalGradient(
            colors = colors,
            startY = start,
            endY = Float.POSITIVE_INFINITY
        )
    )
}
