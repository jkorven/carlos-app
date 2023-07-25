package com.example.carlos_app.ui.screens.register

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.carlos_app.providers.Local
import com.example.carlos_app.providers.LocalExp
import com.example.carlos_app.ui.screens.login.LoginViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@ExperimentalMaterial3Api
@Composable
fun RegisterScreen(
    viewModel: LoginViewModel = LoginViewModel(),
    bottomSheetState: SheetState,
    scope: CoroutineScope
) {
    RegisterContent(
        viewModel = viewModel,
        bottomSheetState = bottomSheetState,
        scope = scope
    )
}

@ExperimentalMaterial3Api
@Composable
fun RegisterContent(
    viewModel: LoginViewModel,
    bottomSheetState: SheetState,
    scope: CoroutineScope
) {
    val navController = Local.NavController.current
    var num = remember{ mutableIntStateOf(0) }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.98f)
    ) {
        Button(
            onClick = {
                scope.launch {
                    bottomSheetState.hide()
                }
            }
        ) {
            Text(
                text = "Back"
            )
        }
        Button(
            onClick = {
                num.value = num.value + 1
            }
        ) {
            Text(
                text = num.value.toString()
            )
        }
    }
}