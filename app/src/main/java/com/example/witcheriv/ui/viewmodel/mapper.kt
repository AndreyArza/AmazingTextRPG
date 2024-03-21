package com.example.witcheriv.ui.viewmodel

import com.example.witcheriv.logic.data.Action
import com.example.witcheriv.logic.data.Model
import com.example.witcheriv.logic.data.Direction
import com.example.witcheriv.logic.data.Game
import com.example.witcheriv.logic.data.Info
import com.example.witcheriv.logic.data.Location
import com.example.witcheriv.logic.data.Stat
import com.example.witcheriv.logic.data.State
import com.example.witcheriv.ui.model.ActionUi
import com.example.witcheriv.ui.model.DirectionUi
import com.example.witcheriv.ui.model.InfoUi
import com.example.witcheriv.ui.model.LocationUi
import com.example.witcheriv.ui.model.ModelUi
import com.example.witcheriv.ui.model.StatUi
import com.example.witcheriv.ui.model.StateUi

fun Model.toUi(game: Game, model: Model) =
    ModelUi(
        location = game.allLocations[locationId]!!.toUi(game, model),
        state = game.allStates[stateId]!!.toUi(model),
        info = info.toUi()
    )

fun Location.toUi(game: Game, model: Model): LocationUi {
   return LocationUi(
        id = id,
        description = description,
        directions = directionsIds.mapNotNull { game.allDirections[it] }.map { it.toUi(model) }
    )
}
fun Direction.toUi(model: Model) = DirectionUi(
    id = id,
    name = name,
    isVisible = isVisible(model)
)

fun State.toUi(model: Model) =
    StateUi(
        id = id,
        description = description,
        actions = actions.map { it.toUi(model) }
    )

fun Action.toUi(model: Model) =
    ActionUi(
        id = id,
        description = description,
        isVisible = isVisible(model)
    )

fun Info.toUi() =
    InfoUi(
        stats.values.map { it.toUi() }
    )

fun Stat.toUi() =
    StatUi(
        name = name,
        order = order,
        values = values.toList().map { it.value }
    )