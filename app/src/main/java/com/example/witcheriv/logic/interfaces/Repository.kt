package com.example.witcheriv.logic.interfaces

import com.example.witcheriv.logic.data.Model
import com.example.witcheriv.logic.data.Game

interface Repository {
    fun getModel(): Model
    fun setModel(model: Model)
    fun getGame(): Game
}