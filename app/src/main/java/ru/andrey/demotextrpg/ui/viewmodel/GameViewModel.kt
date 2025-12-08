package ru.andrey.demotextrpg.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import ru.andrey.demotextrpg.logic.interactors.GameInteractorImpl
import ru.andrey.demotextrpg.logic.interfaces.GameInteractor
import ru.andrey.demotextrpg.ui.model.ActionUi
import ru.andrey.demotextrpg.ui.model.DirectionUi
import ru.andrey.demotextrpg.ui.model.ModelUi

class GameViewModel : ViewModel() {
    private val interactor: GameInteractor = GameInteractorImpl
    private val mutableStateFlow = MutableStateFlow(
        interactor.getModel().toUi(interactor.game, interactor.getModel())
    )
    val stateFlow: StateFlow<ModelUi> = mutableStateFlow.asStateFlow()

    init {
        stateFlow.onEach {
        }.launchIn(viewModelScope)
    }

    fun process(action: ActionUi) {
        mutableStateFlow.update {
            interactor.process(interactor.game.allActions[action.id] ?: return)
                .toUi(interactor.game, interactor.getModel())
        }
    }

    fun transfer(direction: DirectionUi) {
        mutableStateFlow.update {
            interactor.transfer(interactor.game.allDirections[direction.id] ?: return)
                .toUi(interactor.game, interactor.getModel())
        }
    }
}