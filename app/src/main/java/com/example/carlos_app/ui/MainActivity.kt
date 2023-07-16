package com.example.carlos_app.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.carlos_app.CarlosApp
import com.example.carlos_app.ui.theme.CarlosappTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setTheme(R.style.Theme_Carlosapp)
//        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            CarlosappTheme {
                CarlosApp()
            }
        }
    }
}