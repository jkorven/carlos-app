package com.example.carlos_app.providers

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.BottomSheetScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.compositionLocalOf
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import com.example.carlos_app.ui.viewmodel.AppViewModel
import kotlinx.coroutines.CoroutineScope


object Local {
    val NavController: ProvidableCompositionLocal<NavHostController> = compositionLocalOf{
        error("No LocalNavController provided")
    }

    val AppViewModel: ProvidableCompositionLocal<AppViewModel> = compositionLocalOf {
        error("No AppViewModel provided")
    }

    val NavBackStackEntry: ProvidableCompositionLocal<NavBackStackEntry?> = compositionLocalOf {
        error("No NavBackStackEntry provided")
    }

//    val SystemBarsPaddingValues: ProvidableCompositionLocal<PaddingValues> = compositionLocalOf {
//        error("No SystemBarsPaddingValues provided")
//    }
}

@ExperimentalMaterial3Api
object LocalExp {
    val BottomSheetScaffoldState: ProvidableCompositionLocal<BottomSheetScaffoldState> = compositionLocalOf {
        error("No BottomSheetScaffoldState provided")
    }
}