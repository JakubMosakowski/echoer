package com.jakmos.echoer.presentation.common.flow

import kotlinx.coroutines.flow.MutableStateFlow

inline fun <T> MutableStateFlow<T>.reduce(block: T.() -> T) {
    value = block(value)
}
