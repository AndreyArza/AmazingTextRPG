package com.example.witcheriv.logic.interfaces

import com.example.witcheriv.logic.data.Action
import com.example.witcheriv.logic.data.Model
import com.example.witcheriv.logic.data.Direction
import com.example.witcheriv.logic.data.Game

interface GameInteractor {
    fun getModel(): Model
    fun transfer(direction: Direction): Model
    fun process(actionId: Action): Model
    val game: Game
}
