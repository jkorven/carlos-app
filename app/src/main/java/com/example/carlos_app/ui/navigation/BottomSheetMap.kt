package com.example.carlos_app.ui.navigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.BottomSheetScaffoldState
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.carlos_app.ui.viewmodel.AppState
import com.example.carlos_app.util.Screen
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


@ExperimentalMaterial3Api
@Composable
fun BottomSheetMap(
    currentRoute: String?,
    bottomSheetScaffoldState: BottomSheetScaffoldState
) {
    when(currentRoute) {
        Screen.LoginScreen.route -> RegisterSheetContent(bottomSheetScaffoldState)
        else -> BotSheetContent(bottomSheetScaffoldState = bottomSheetScaffoldState)
    }
}

@ExperimentalMaterial3Api
@Composable
fun RegisterSheetContent(
    bottomSheetScaffoldState: BottomSheetScaffoldState
) {
    val scope = rememberCoroutineScope()
    val viewModel: RegisterViewModel = viewModel()
    val state = viewModel.state.collectAsState()
    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Button(
                modifier = Modifier
                    .height(100.dp)
                    .width(200.dp),
                onClick = {
                    scope.launch {
                        bottomSheetScaffoldState.bottomSheetState.hide()
                    }
                }
            ) {
                Text(
                    text = "Register"
                )
            }
            Button(
                modifier = Modifier
                    .height(100.dp)
                    .width(200.dp),
                onClick = {
                    viewModel.setState(
                        num = state.value.num + 1
                    )
                }
            ) {
                Text(
                    text = state.value.num.toString()
                )
            }
        }


    }
}

class RegisterViewModel: ViewModel() {
    data class AppState (
        val num: Int = 0
    )
    private val _state = MutableStateFlow(AppState())
    val state: StateFlow<AppState> = _state.asStateFlow()

    fun setState(
        num: Int = _state.value.num
    ) {
        _state.update {
            it.copy(
                num = num
            )
        }
    }
}

@ExperimentalMaterial3Api
@Composable
fun BotSheetContent(
    bottomSheetScaffoldState: BottomSheetScaffoldState
) {
    val scope = rememberCoroutineScope()

    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Box(
            contentAlignment = Alignment.Center
        ) {
            Button(
                modifier = Modifier
                    .height(100.dp)
                    .width(200.dp),
                onClick = {
                    scope.launch {
                        bottomSheetScaffoldState.bottomSheetState.hide()
                    }
                }
            ) {
                Text(
                    text = "Hello"
                )
            }
        }


    }
}