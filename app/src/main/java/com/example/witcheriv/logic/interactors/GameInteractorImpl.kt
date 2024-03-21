package com.example.witcheriv.logic.interactors

import com.example.witcheriv.logic.data.Action
import com.example.witcheriv.logic.data.Model
import com.example.witcheriv.logic.data.Direction
import com.example.witcheriv.data.repository.RepositoryImpl
import com.example.witcheriv.logic.interfaces.GameInteractor
import com.example.witcheriv.logic.interfaces.Repository

object GameInteractorImpl : GameInteractor {
    private val repository: Repository = RepositoryImpl
    override val game = repository.getGame()

    override fun getModel() = repository.getModel()


    override fun transfer(direction: Direction): Model {
        val model = repository.getModel()
        val dataModel1 = model.copy(
            locationId = direction.destinationId,
            stateId = game.allLocations[direction.destinationId]?.defaultStateId ?: return model
        )
        repository.setModel(
            dataModel1
        )
        return repository.getModel()
    }

    override fun process(action: Action): Model {
        val model = repository.getModel()
        val newModel = if (action.successCheck(model)) {
            action.sideEffect(game, model)
        } else {
            action.failSideEffect(game, model)
        }

        repository.setModel(
            newModel
        )
        return repository.getModel()
    }

}
