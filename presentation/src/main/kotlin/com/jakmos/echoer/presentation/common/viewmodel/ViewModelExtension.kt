package com.jakmos.echoer.presentation.common.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jakmos.echoer.presentation.common.dispatcher.DispatcherProviderWrapper
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

val dispatcherProvider
    get() = DispatcherProviderWrapper.provider

fun ViewModel.launchInBackground(block: suspend CoroutineScope.() -> Unit): Job =
    viewModelScope.launch(dispatcherProvider.default, block = block)

fun ViewModel.launchInIO(block: suspend CoroutineScope.() -> Unit): Job =
    viewModelScope.launch(dispatcherProvider.io, block = block)

fun ViewModel.launchInMain(block: suspend CoroutineScope.() -> Unit): Job =
    viewModelScope.launch(dispatcherProvider.main, block = block)

suspend fun <T> ViewModel.onBackground(block: suspend CoroutineScope.() -> T): T =
    withContext(dispatcherProvider.default, block)

suspend fun <T> ViewModel.onIO(block: suspend CoroutineScope.() -> T): T =
    withContext(dispatcherProvider.io, block)

suspend fun <T> ViewModel.onMain(block: suspend CoroutineScope.() -> T): T =
    withContext(dispatcherProvider.main, block)

suspend fun <T> Channel<T>.sendOnMain(element: T) {
    withContext(DispatcherProviderWrapper.provider.main) {
        send(element)
    }
}
