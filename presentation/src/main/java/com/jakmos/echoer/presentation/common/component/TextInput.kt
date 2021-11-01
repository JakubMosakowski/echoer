package com.jakmos.echoer.presentation.common.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation

@Composable
fun EchoerTextInput(
    initialValue: String = "",
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    label: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    singleLine: Boolean = true
) {
    val state = remember { mutableStateOf(initialValue) }

    OutlinedTextField(
        value = state.value,
        onValueChange = {
            state.value = it
            onValueChange(it)
        },
        label = label,
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        trailingIcon = trailingIcon,
        visualTransformation = visualTransformation,
        singleLine = singleLine
    )
}

@Composable
fun PasswordTextInput(
    initialValue: String = "",
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    label: @Composable (() -> Unit)? = null
) {

    val passwordVisibility = remember { mutableStateOf(false) }

    EchoerTextInput(
        initialValue = initialValue,
        trailingIcon = { PasswordVisibilityIcon(passwordVisibility) },
        visualTransformation = if (passwordVisibility.value) VisualTransformation.None else
            PasswordVisualTransformation(),
        onValueChange = onValueChange,
        modifier = modifier,
        label = label
    )
}

@Composable
fun PasswordVisibilityIcon(passwordVisibility: MutableState<Boolean>) {
    val image = if (passwordVisibility.value)
        Icons.Filled.Visibility
    else Icons.Filled.VisibilityOff

    IconButton(onClick = { passwordVisibility.value = !passwordVisibility.value }) {
        Icon(imageVector = image, "")
    }
}
