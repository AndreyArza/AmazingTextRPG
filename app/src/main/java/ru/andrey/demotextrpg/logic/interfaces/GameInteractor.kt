package ru.andrey.demotextrpg.logic.interfaces

import ru.andrey.demotextrpg.logic.data.Action
import ru.andrey.demotextrpg.logic.data.Direction
import ru.andrey.demotextrpg.logic.data.Game
import ru.andrey.demotextrpg.logic.data.Model

interface GameInteractor {
    fun getModel(): Model
    fun transfer(direction: Direction): Model
    fun process(actionId: Action): Model
    val game: Game
}
