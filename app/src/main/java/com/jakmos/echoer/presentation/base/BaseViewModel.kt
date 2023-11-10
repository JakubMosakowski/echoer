package com.jakmos.echoer.presentation.base

import androidx.lifecycle.ViewModel
import org.orbitmvi.orbit.ContainerHost

abstract class BaseViewModel<State : Any, SideEffect : Any> :
    ContainerHost<State, SideEffect>, ViewModel()
