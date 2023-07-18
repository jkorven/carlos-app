package com.example.carlos_app.ui.screens.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.indication
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.carlos_app.R
import com.example.carlos_app.ui.components.StandardTextField
import com.example.carlos_app.ui.theme.DarkGray
import com.example.carlos_app.ui.theme.LightGray
import com.example.carlos_app.ui.theme.SolidWhite
import com.example.carlos_app.ui.theme.SpaceLarge
import com.example.carlos_app.ui.theme.officinaSerif
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
        Surface(
            modifier = Modifier
                .fillMaxSize(),
            color = Color.Black.copy(alpha = 0f)
        ) {
// Content column
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .align(Alignment.Center)
                    .padding(
                        start = SpaceLarge,
                        end = SpaceLarge,
                        top = 50.dp,
                        bottom = 50.dp
                    )
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .padding(
                            start = 30.dp,
                            end = 30.dp,
                            top = 50.dp,
                            bottom = 50.dp
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(bottom = 10.dp),
                        alignment = Alignment.BottomCenter,
                        painter = painterResource(R.drawable.logo_image),
                        contentDescription = null,
                        alpha = 0.3f,
                        contentScale = ContentScale.Fit
                    )
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                    ) {
                        Spacer(modifier = Modifier.weight(1f))
                        Text(
                            modifier = Modifier
                                .fillMaxWidth(),
                            text = "Carlos O'Kelly's",
                            fontFamily = officinaSerif,
                            fontSize = 32.sp,
                            fontWeight = FontWeight.Bold,
                            color = SolidWhite,
                            lineHeight = 1.sp,
                            textAlign = TextAlign.Center
                        )
                        Text(
                            modifier = Modifier
                                .fillMaxWidth(),
                            text = "Inspired Mex",
                            fontFamily = officinaSerif,
                            fontSize = 20.sp,
                            fontStyle = FontStyle.Italic,
                            lineHeight = 1.sp,
                            color = SolidWhite,
                            textAlign = TextAlign.Center
                        )
                    }
                }
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    StandardTextField(
                        modifier = Modifier
                            .border(1.dp, SolidWhite)
                            .shadow(elevation = 5.dp),
                        text = state.value.userName,
                        onValueChange = {
                            viewModel.setState(userName = it)
                        },
                        keyboardType = KeyboardType.Email,
                        error = "",
                        hint = {
                            Text(
                                text = stringResource(R.string.login_hint),
                                color = LightGray
                            )
                        },
                        style = TextStyle(
                            color = DarkGray
                        ),
                        leadingIcon = Icons.Default.Person,
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = SolidWhite.copy(alpha = 1f),
                            unfocusedContainerColor = SolidWhite.copy(alpha = 0.9f)
                        )
                    )
                    Spacer(modifier = Modifier.height(SpaceLarge))
                    StandardTextField(
                        modifier = Modifier
                            .border(1.dp, SolidWhite)
                            .shadow(elevation = 5.dp),
                        text = state.value.password,
                        onValueChange = {
                            viewModel.setState(password = it)
                        },
                        hint = {
                            Text(
                                text = stringResource(R.string.password_hint),
                                color = LightGray
                            )
                        },
                        style = TextStyle(
                            color = DarkGray
                        ),
                        leadingIcon = Icons.Default.Lock,
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = SolidWhite.copy(alpha = 1f),
                            unfocusedContainerColor = SolidWhite.copy(alpha = 0.9f)
                        ),
                        keyboardType = KeyboardType.Password,
                        error = state.value.passwordError,
                        isPasswordVisible = state.value.showPassword,
                        onPasswordToggleClick = {
                            viewModel.setState(showPassword = it)
                        }
                    )
                    Spacer(modifier = Modifier.height(SpaceLarge))
                    Surface(
                        shadowElevation = 5.dp,
                        color = Color.Transparent
                    ) {
                        Button(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(60.dp)
                                .border(2.dp, SolidWhite, RoundedCornerShape(5.dp))
                                .indication(
                                    interactionSource = MutableInteractionSource(),
                                    indication = rememberRipple(
                                        bounded = true,
                                        color = Color.Transparent
                                    )
                                ),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.Black.copy(alpha = 0.2f)
                            ),
                            onClick = {
                                navController.navigate(
                                    Screen.HomeScreen.route
                                )
                            }
                        ) {
                            Text (
                                text = stringResource(R.string.login),
                                color = MaterialTheme.colorScheme.onPrimary,
                                fontSize = 24.sp
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(SpaceLarge))
                    Surface(
                        shadowElevation = 5.dp,
                        color = Color.Transparent
                    ) {
                        Button(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(60.dp)
                                .border(2.dp, SolidWhite, RoundedCornerShape(5.dp))
                                .indication(
                                    interactionSource = MutableInteractionSource(),
                                    indication = rememberRipple(
                                        bounded = true,
                                        color = Color.Transparent
                                    )
                                ),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.Black.copy(alpha = 0.2f)
                            ),
                            onClick = {
//                            navController.navigate(
//                                Screen.HomeScreen.route
//                            )
                            },
                        ) {
                            Text (
                                text = stringResource(R.string.create_account),
                                color = MaterialTheme.colorScheme.onPrimary,
                                fontSize = 24.sp
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(SpaceLarge))
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable(
                                interactionSource = MutableInteractionSource(),
                                indication = rememberRipple(
                                    bounded = true,
                                    color = Color.Transparent
                                ),
                                onClick = {
                                    navController.navigate(Screen.HomeScreen.route)
                                }
                            ),
                        text = stringResource(R.string.continue_as_guest),
                        style = MaterialTheme.typography.titleMedium,
                        color = SolidWhite,
                        textAlign = TextAlign.Center,
                        textDecoration = TextDecoration.Underline
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun LoginScreenPreview() {
    LoginScreen(navController = rememberNavController())
}
