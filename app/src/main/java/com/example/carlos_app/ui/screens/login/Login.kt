package com.example.carlos_app.ui.screens.login

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.carlos_app.R
import com.example.carlos_app.ui.components.StandardTextField
import com.example.carlos_app.ui.theme.DarkGray
import com.example.carlos_app.ui.theme.SolidWhite
import com.example.carlos_app.ui.theme.SpaceLarge
import com.example.carlos_app.ui.theme.SpaceMedium
import com.example.carlos_app.util.Screen

@Composable
fun LoginScreen(
    navController: NavHostController
) {
    val viewModel = LoginViewModel()
    LoginContent(
        navController,
        viewModel
    )
}

@Composable
fun LoginContent(
    navController: NavHostController,
    viewModel: LoginViewModel
) {
    val state = viewModel.state.collectAsState()
    BoxWithConstraints (
        modifier = Modifier
            .fillMaxSize()

    ) {
        // Background image
        Image(
            modifier = Modifier
                .fillMaxSize(),
            painter = painterResource(R.drawable.background_full_dark60),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        // Content column
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.Center)
                .padding(
                    start = SpaceLarge,
                    end = SpaceLarge,
                    top = SpaceLarge,
                    bottom = 50.dp
                )
        ) {
            Text(
                text = stringResource(R.string.login),
                style = MaterialTheme.typography.bodyLarge,
                color = SolidWhite
            )
            Spacer(modifier = Modifier.height(SpaceMedium))

            StandardTextField(
                text = state.value.userName,
                onValueChange = {
                    viewModel.setState(userName = it)
                },
                keyboardType = KeyboardType.Email,
                error = "",
                hint = {
                    Text(
                        text = stringResource(R.string.login_hint)
                    )
                }
            )
            Spacer(modifier = Modifier.height(SpaceMedium))
            StandardTextField(
                text = state.value.password,
                onValueChange = {
                    viewModel.setState(password = it)
                },
                hint = {
                    Text(
                        text = stringResource(R.string.password_hint)
                    )
                },
                keyboardType = KeyboardType.Password,
                error = state.value.passwordError,
                isPasswordVisible = state.value.showPassword,
                onPasswordToggleClick = {
                    viewModel.setState(showPassword = it)
                }
            )
            Spacer(modifier = Modifier.height(SpaceMedium))
            Button(
                onClick = {
                    navController.navigate(
                        Screen.HomeScreen.route
                    )
                }
            ) {
                Text (
                    text = stringResource(R.string.login),
                    color = MaterialTheme.colorScheme.onPrimary
                )
            }
        }
    }
}