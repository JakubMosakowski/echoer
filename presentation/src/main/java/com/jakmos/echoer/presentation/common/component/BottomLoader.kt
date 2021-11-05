package com.jakmos.echoer.presentation.common.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jakmos.echoer.presentation.common.theme.colorAccent
import com.jakmos.echoer.presentation.common.theme.colorPrimary

@Composable
fun BottomLoader(
    isLoading: Boolean
) = AnimatedVisibility(
    isLoading,
    enter = slideInVertically({ 100.dp.value.toInt() }),
    exit = slideOutVertically({ 100.dp.value.toInt() })
) {
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter) {
        HillBackground {
            CircularProgressIndicator(
                color = colorAccent,
                modifier = Modifier.size(32.dp)
            )
        }
    }
}

@Composable
private fun HillBackground(content: @Composable () -> Unit) = Surface(
    shape = HillShape,
    color = colorPrimary,
    modifier = Modifier
        .width(70.dp)
        .height(50.dp)
) {
    Box(
        Modifier.padding(6.dp),
        contentAlignment = Alignment.Center
    ) { content() }
}

private val HillShape = GenericShape { size, _ ->

    // Move to start
    moveTo(0f, size.height)

    // Draw first half of the shape.
    quadraticBezierTo(size.width * 0.1f, size.height * 0.01f, size.width / 2, 0f)

    // Draw second half of the shape.
    quadraticBezierTo(size.width * 0.9f, size.height * 0.01f, size.width, size.height)
}

@Composable
@Preview
fun BottomLoaderPreview() {
    BottomLoader(true)
}
