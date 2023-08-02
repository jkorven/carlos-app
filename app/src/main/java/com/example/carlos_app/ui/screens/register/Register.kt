package com.example.carlos_app.ui.screens.register

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomSheetState
import androidx.compose.material.BottomSheetValue
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.rememberBottomSheetState
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.carlos_app.R
import com.example.carlos_app.data.RegisterRepository
import com.example.carlos_app.providers.Local
import com.example.carlos_app.ui.components.StandardTextField
import com.example.carlos_app.ui.theme.DarkGray
import com.example.carlos_app.ui.theme.IconSizeMedium
import com.example.carlos_app.ui.theme.LightGray
import com.example.carlos_app.ui.theme.SolidWhite
import com.example.carlos_app.ui.theme.SpaceLarge
import com.example.carlos_app.util.Constants
import com.example.carlos_app.util.Ext.toDP
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@ExperimentalMaterialApi
@Composable
fun RegisterScreen(
    bottomSheetState: BottomSheetState,
    scope: CoroutineScope
) {
    val viewModel: RegisterViewModel = viewModel()

    RegisterContent(
        viewModel = viewModel,
        bottomSheetState = bottomSheetState,
        scope = scope
    )
}

@ExperimentalMaterialApi
@Composable
fun RegisterContent(
    viewModel: RegisterViewModel,
    bottomSheetState: BottomSheetState,
    scope: CoroutineScope
) {
    val globalViewModel = Local.AppViewModel.current
    val globalState = globalViewModel.state.collectAsState()
    val state = viewModel.state.collectAsState()
    val paddingValues = WindowInsets.systemBars.asPaddingValues()
    val focusManager = LocalFocusManager.current
    val thirdPartyLoginButtonsList = RegisterRepository.getLoginButtonData()
    val textFieldsList = RegisterRepository.getRegisterData(viewModel, state)
    val navController = Local.NavController.current
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(globalState.value.size.height.toDP() - paddingValues.calculateTopPadding())
            .background(SolidWhite)
    ) {
        // Sheet toolbar
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
                            bottomSheetState.collapse()
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
                fontSize = MaterialTheme.typography.subtitle1.fontSize,
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
                .imePadding()
        ) {
            item{
                Spacer(modifier = Modifier.height(SpaceLarge))
            }
            items(items = thirdPartyLoginButtonsList, itemContent = {
                StandardRegisterButton(
                    text = it.text,
                    icon = it.icon,
                    containerColor = it.containerColor,
                    contentColor = it.contentColor,
                    borderColor = it.borderColor
                )
                Spacer(modifier = Modifier.height(SpaceLarge))
            })
            items(items = textFieldsList, itemContent = {
                RegisterTextField(
                    viewModel = viewModel,
                    state = state,
                    text = it.text,
                    onValueChange = it.onValueChange,
                    keyboardType = it.keyboardType,
                    hint = it.hint,
                    isPassword = it.isPassword
                )
                Spacer(modifier = Modifier.height(SpaceLarge))
            })
            item{
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(70.dp),
                    onClick = {

                    },
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color.Blue,
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

@Composable
fun RegisterTextField(
    viewModel: RegisterViewModel,
    state: State<RegisterState>,
    text: String,
    onValueChange: (String) -> Unit,
    keyboardType: KeyboardType,
    hint: Int,
    isPassword: Boolean
) {
    StandardTextField(
        modifier = Modifier
            .shadow(elevation = 5.dp),
        text = text,
        onValueChange = onValueChange,
        keyboardType = keyboardType,
        hint = {
            Text(
                text = stringResource(hint),
                color = LightGray
            )
        },
        style = TextStyle(
            color = DarkGray
        ),
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = SolidWhite,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        error = if(isPassword) {
            when (state.value.passwordError) {
                RegisterState.PasswordError.FieldEmpty -> {
                    stringResource(R.string.this_field_cant_be_empty)
                }
                RegisterState.PasswordError.InputTooShort -> {
                    stringResource(R.string.input_too_short, Constants.MIN_PASSWORD_LENGTH)
                }
                RegisterState.PasswordError.InvalidPassword -> {
                    stringResource(R.string.invalid_password)
                }
                null -> ""
            }
        } else { "" },
        isPasswordVisible = if(isPassword) state.value.isPasswordVisible else false,
        onPasswordToggleClick = {
            if(isPassword) {
                viewModel.onEvent(RegisterEvent.TogglePasswordVisibility)
            }
        }
    )
}

@Composable
fun StandardRegisterButton(
    text: Int,
    icon: Int? = null,
    containerColor: Color,
    contentColor: Color,
    borderColor: Color? = null,
    contentDescription: String? = null
) {
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp),
        onClick = {
            //TODO
        },
        colors = ButtonDefaults.buttonColors(
            backgroundColor = containerColor,
            contentColor = contentColor
        ),
        shape = RoundedCornerShape(10.dp),
        border = if(borderColor != null) {
            BorderStroke(2.dp, borderColor)
        } else null
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            if(icon != null) {
                Icon(
                    painter = painterResource(icon),
                    contentDescription = contentDescription,
                    modifier = Modifier
                        .size(IconSizeMedium),
                    tint = contentColor
                )
                Spacer(modifier = Modifier.width(12.dp))
            }
            Text(
                text = stringResource(text).uppercase(),
                fontSize = MaterialTheme.typography.h6.fontSize
            )
        }
    }
}

@ExperimentalMaterialApi
@Preview
@Composable
fun RegisterScreenPreview() {
    val bottomSheetState = rememberBottomSheetState(
        initialValue = BottomSheetValue.Collapsed
    )
    val scope = rememberCoroutineScope()
    RegisterScreen(bottomSheetState = bottomSheetState, scope = scope)
}