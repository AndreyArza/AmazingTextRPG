package ru.andrey.demotextrpg.logic.interactors

import ru.andrey.demotextrpg.logic.data.Action
import ru.andrey.demotextrpg.logic.data.Direction
import ru.andrey.demotextrpg.logic.data.Game
import ru.andrey.demotextrpg.logic.data.Model
import ru.andrey.demotextrpg.logic.interfaces.GameInteractor

object GameInteractorImpl : GameInteractor {
//    private val repository: Repository = RepositoryImpl
//    override val game = repository.getGame()

    override fun getModel() = TODO() //repository.getModel()


    override fun transfer(direction: Direction): Model {
        val model = TODO()//repository.getModel()
//        val dataModel1 = model.copy(
//            locationId = direction.destinationId,
//            stateId = game.allLocations[direction.destinationId]?.defaultStateId ?: return model
//        )
//        repository.setModel(
//            dataModel1
//        )
//        return repository.getModel()
    }

    override fun process(action: Action): Model {
        TODO()
//        val model = repository.getModel()
//        val newModel = if (action.successCheck(model)) {
//            action.sideEffect(game, model)
//        } else {
//            action.failSideEffect(game, model)
//        }
//
//        repository.setModel(
//            newModel
//        )
//        return repository.getModel()
    }

    override val game: Game
        get() = TODO("Not yet implemented")

}
