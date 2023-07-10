package com.example.carlos_app.data.json

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.unit.dp
import java.util.Locale
import java.util.Objects

class Spotlights() {
    val spotlight1 = Entry(
        "Chicken",
        "https://cdn-assets.greatplainsmfg.com/ag_files/styles/scale_crop_500px/public/product-studio-image/bd7600-studio.png",
        "",
        "Text"
    )
    val spotlight2 = Entry(
        "Beef",
        "https://cdn-assets.greatplainsmfg.com/ag_files/styles/scale_crop_500px/public/product-studio-image/bd7600-studio.png",
        "",
        "Text"
    )
    val spotlight3 = Entry("Pork",
        "https://cdn-assets.greatplainsmfg.com/ag_files/styles/scale_crop_500px/public/product-studio-image/bd7600-studio.png",
        "",
        "Text"
    )
    val spotlight4 = Entry("Fish",
        "https://cdn-assets.greatplainsmfg.com/ag_files/styles/scale_crop_500px/public/product-studio-image/bd7600-studio.png",
        "",
        "Text"
    )
    val spotlight5 = Entry("Vegan",
        "https://cdn-assets.greatplainsmfg.com/ag_files/styles/scale_crop_500px/public/product-studio-image/bd7600-studio.png",
        "",
        description = "Text"
    )
    val splotlights = listOf(spotlight1, spotlight2, spotlight3, spotlight4, spotlight5)
}

class Entry(title: String, imageUrl: String, backgroundUrl: String, description: String) {
    val title = title
    val image = imageUrl
    val description = description
    val background = backgroundUrl
}


