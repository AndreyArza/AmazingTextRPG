package ru.andrey.demotextrpg.domain.repository

import ru.andrey.demotextrpg.domain.model.Game
import ru.andrey.demotextrpg.domain.model.Model

interface Repository {
    fun getModel(): Model
    fun setModel(model: Model)
    fun getGame(): Game
}