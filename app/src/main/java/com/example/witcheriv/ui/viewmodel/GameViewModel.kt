package com.example.witcheriv.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.witcheriv.ui.model.ActionUi
import com.example.witcheriv.ui.model.DirectionUi
import com.example.witcheriv.ui.model.ModelUi
import com.example.witcheriv.logic.interactors.GameInteractorImpl
import com.example.witcheriv.logic.interfaces.GameInteractor
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update

class GameViewModel : ViewModel() {
    private val interactor: GameInteractor = GameInteractorImpl
    private val mutableStateFlow = MutableStateFlow(
        interactor.getModel().toUi(interactor.game, interactor.getModel())
    )
    val stateFlow: StateFlow<ModelUi> = mutableStateFlow.asStateFlow()

    init {
        stateFlow.onEach {
            Log.e("AAAAAAAA", it.toString())
        }.launchIn(viewModelScope)
    }

    fun process(action: ActionUi) {
        mutableStateFlow.update {
            interactor.process(interactor.game.allActions[action.id] ?: return).toUi(interactor.game, interactor.getModel())
        }
    }
    fun transfer(direction: DirectionUi){
        mutableStateFlow.update {
            interactor.transfer(interactor.game.allDirections[direction.id]?: return).toUi(interactor.game, interactor.getModel())
        }
    }
}