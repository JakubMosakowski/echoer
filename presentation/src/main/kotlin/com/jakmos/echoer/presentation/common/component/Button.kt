package com.jakmos.echoer.presentation.common.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun EchoerButton(
    enabled: Boolean = true,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    text: String
) = Button(
    modifier = modifier
        .fillMaxWidth()
        .height(56.dp),
    onClick = { onClick() },
    enabled = enabled,
    colors = ButtonDefaults.buttonColors(
        backgroundColor = MaterialTheme.colors.primary,
        contentColor = MaterialTheme.colors.onPrimary
    )
) { Text(text = text.uppercase()) }
