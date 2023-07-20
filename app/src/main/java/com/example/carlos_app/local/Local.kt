package com.example.carlos_app.local

import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.compositionLocalOf
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import com.example.carlos_app.ui.viewmodel.AppViewModel

object Local {
    val NavController: ProvidableCompositionLocal<NavHostController> = compositionLocalOf{
        error("No LocalNavController provided")
    }

    val AppViewModel: ProvidableCompositionLocal<AppViewModel> = compositionLocalOf {
        error("No AppViewModel provided")
    }
}