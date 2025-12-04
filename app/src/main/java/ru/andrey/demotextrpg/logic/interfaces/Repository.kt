package ru.andrey.demotextrpg.logic.interfaces

import ru.andrey.demotextrpg.logic.data.Model
import ru.andrey.demotextrpg.logic.data.Game

interface Repository {
    fun getModel(): Model
    fun setModel(model: Model)
    fun getGame(): Game
}