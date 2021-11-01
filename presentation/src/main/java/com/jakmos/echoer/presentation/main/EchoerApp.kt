package com.jakmos.echoer.presentation.main

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.jakmos.echoer.presentation.common.theme.EchoerTheme

@Composable
fun EchoerApp() {

    EchoerTheme {
        val navController = rememberNavController()
        NavGraph(navController)
    }
}

