package ru.andrey.demotextrpg.ui.splash.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import ru.andrey.demotextrpg.network.source.interfaces.NetworkSource
import javax.inject.Inject

class SplashViewModel @Inject constructor(
    private val networkSource: NetworkSource
) : ViewModel() {
    private val _state =
        MutableStateFlow(0)
    val state = _state.asStateFlow()


    init{
        viewModelScope.launch {
            networkSource.getActions("", 10).collect {
                _state.value = it.getOrThrow().loaded
            }
        }
    }
}