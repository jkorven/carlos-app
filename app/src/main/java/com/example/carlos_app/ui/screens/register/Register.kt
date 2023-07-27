package com.example.carlos_app.ui.screens.register

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.ScrollableDefaults
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SheetState
import androidx.compose.material3.SheetValue
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.rememberStandardBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key.Companion.D
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.rememberNestedScrollInteropConnection
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.carlos_app.R
import com.example.carlos_app.providers.Local
import com.example.carlos_app.ui.components.StandardTextField
import com.example.carlos_app.ui.theme.DarkGray
import com.example.carlos_app.ui.theme.LightGray
import com.example.carlos_app.ui.theme.SolidWhite
import com.example.carlos_app.ui.theme.SpaceLarge
import com.example.carlos_app.util.toDP
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@ExperimentalMaterial3Api
@Composable
fun RegisterScreen(
    bottomSheetState: SheetState,
    scope: CoroutineScope
) {
    val viewModel: RegisterViewModel = viewModel()
    RegisterContent(
        viewModel = viewModel,
        bottomSheetState = bottomSheetState,
        scope = scope
    )
}

@ExperimentalMaterial3Api
@Composable
fun RegisterContent(
    viewModel: RegisterViewModel,
    bottomSheetState: SheetState,
    scope: CoroutineScope
) {
    val globalViewModel = Local.AppViewModel.current
    val globalState = globalViewModel.state.collectAsState()
    val paddingValues = WindowInsets.systemBars.asPaddingValues()
    val state = viewModel.state.collectAsState()
    val focusManager = LocalFocusManager.current
    val navController = Local.NavController.current
    var num = remember{ mutableIntStateOf(0) }
    BoxWithConstraints(
        modifier = Modifier
            .fillMaxWidth()
            .height(globalState.value.size.height.toDP() - paddingValues.calculateTopPadding())
            .background(SolidWhite)
            .nestedScroll(rememberNestedScrollInteropConnection())
    ) {
        val toolbarHeight = 50.dp
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(toolbarHeight)
                .background(Color.Red),
            contentAlignment = Alignment.CenterStart
        ) {
            Icon(
                modifier = Modifier
                    .clickable {
                        scope.launch {
                            focusManager.clearFocus()
                            bottomSheetState.hide()
                        }
                    }
                    .padding(start = 10.dp)
                    .height(24.dp)
                    .width(24.dp),
                imageVector = Icons.Default.Close,
                contentDescription = null,
                tint = SolidWhite
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                color = SolidWhite,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                text = stringResource(R.string.sign_up).uppercase()
            )
        }
        // Content column
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = toolbarHeight, start = 25.dp, end = 25.dp)
        ) {
            item{
                Spacer(modifier = Modifier.height(SpaceLarge))
            }
            item{
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(70.dp),
                    onClick = {

                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Blue,
                        contentColor = SolidWhite
                    ),
                    shape = RoundedCornerShape(3.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                    }
                }
            }
            item{
                Spacer(modifier = Modifier.height(SpaceLarge))
            }
            item{
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(70.dp),
                    onClick = {

                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Blue,
                        contentColor = SolidWhite
                    ),
                    shape = RoundedCornerShape(3.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                    }
                }
            }
            item{
                Spacer(modifier = Modifier.height(SpaceLarge))
            }
            item{
                StandardTextField(
                    modifier = Modifier
                        .shadow(elevation = 5.dp),
                    text = state.value.firstnameText,
                    onValueChange = {
                        viewModel.onEvent(RegisterEvent.EnteredFirstname(it))
                    },
                    keyboardType = KeyboardType.Email,
                    error = "",
                    hint = {
                        Text(
                            text = stringResource(R.string.first_name),
                            color = LightGray
                        )
                    },
                    style = TextStyle(
                        color = DarkGray
                    ),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = SolidWhite,
                        unfocusedContainerColor = SolidWhite,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    )
                )
            }
            item{
                Spacer(modifier = Modifier.height(SpaceLarge))
            }
            item{
                StandardTextField(
                    modifier = Modifier
                        .shadow(elevation = 5.dp),
                    text = state.value.lastnameText,
                    onValueChange = {
                        viewModel.onEvent(RegisterEvent.EnteredLastname(it))
                    },
                    keyboardType = KeyboardType.Email,
                    error = "",
                    hint = {
                        Text(
                            text = stringResource(R.string.last_name),
                            color = LightGray
                        )
                    },
                    style = TextStyle(
                        color = DarkGray
                    ),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = SolidWhite,
                        unfocusedContainerColor = SolidWhite,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    )
                )
            }
            item{
                Spacer(modifier = Modifier.height(SpaceLarge))
            }
            item{
                StandardTextField(
                    modifier = Modifier
                        .shadow(elevation = 5.dp),
                    text = state.value.lastnameText,
                    onValueChange = {
                        viewModel.onEvent(RegisterEvent.EnteredLastname(it))
                    },
                    keyboardType = KeyboardType.Email,
                    error = "",
                    hint = {
                        Text(
                            text = stringResource(R.string.last_name),
                            color = LightGray
                        )
                    },
                    style = TextStyle(
                        color = DarkGray
                    ),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = SolidWhite,
                        unfocusedContainerColor = SolidWhite,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    )
                )
            }
            item{
                Spacer(modifier = Modifier.height(SpaceLarge))
            }
            item{
                StandardTextField(
                    modifier = Modifier
                        .shadow(elevation = 5.dp),
                    text = state.value.lastnameText,
                    onValueChange = {
                        viewModel.onEvent(RegisterEvent.EnteredLastname(it))
                    },
                    keyboardType = KeyboardType.Email,
                    error = "",
                    hint = {
                        Text(
                            text = stringResource(R.string.last_name),
                            color = LightGray
                        )
                    },
                    style = TextStyle(
                        color = DarkGray
                    ),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = SolidWhite,
                        unfocusedContainerColor = SolidWhite,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    )
                )
            }
            item{
                Spacer(modifier = Modifier.height(SpaceLarge))
            }
            item{
                StandardTextField(
                    modifier = Modifier
                        .shadow(elevation = 5.dp),
                    text = state.value.lastnameText,
                    onValueChange = {
                        viewModel.onEvent(RegisterEvent.EnteredLastname(it))
                    },
                    keyboardType = KeyboardType.Email,
                    error = "",
                    hint = {
                        Text(
                            text = stringResource(R.string.last_name),
                            color = LightGray
                        )
                    },
                    style = TextStyle(
                        color = DarkGray
                    ),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = SolidWhite,
                        unfocusedContainerColor = SolidWhite,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    )
                )
            }
            item{
                Spacer(modifier = Modifier.height(SpaceLarge))
            }
            item{
                StandardTextField(
                    modifier = Modifier
                        .shadow(elevation = 5.dp),
                    text = state.value.lastnameText,
                    onValueChange = {
                        viewModel.onEvent(RegisterEvent.EnteredLastname(it))
                    },
                    keyboardType = KeyboardType.Email,
                    error = "",
                    hint = {
                        Text(
                            text = stringResource(R.string.last_name),
                            color = LightGray
                        )
                    },
                    style = TextStyle(
                        color = DarkGray
                    ),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = SolidWhite,
                        unfocusedContainerColor = SolidWhite,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    )
                )
            }
            item{
                Spacer(modifier = Modifier.height(SpaceLarge))
            }
            item{
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(70.dp),
                    onClick = {

                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Blue,
                        contentColor = SolidWhite
                    ),
                    shape = RoundedCornerShape(3.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                    }
                }
            }
            item{
                Spacer(modifier = Modifier.height(SpaceLarge))
            }
        }
    }
}

@ExperimentalMaterial3Api
@Preview
@Composable
fun RegisterScreenPreview() {
    val bottomSheetState = rememberStandardBottomSheetState(
        initialValue = SheetValue.Hidden,
        skipHiddenState = false
    )
    val scope = rememberCoroutineScope()
    RegisterScreen(bottomSheetState = bottomSheetState, scope = scope)
}