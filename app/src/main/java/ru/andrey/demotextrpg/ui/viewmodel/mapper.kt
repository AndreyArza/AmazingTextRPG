package ru.andrey.demotextrpg.ui.viewmodel

import ru.andrey.demotextrpg.logic.data.Action
import ru.andrey.demotextrpg.logic.data.Direction
import ru.andrey.demotextrpg.logic.data.Game
import ru.andrey.demotextrpg.logic.data.Info
import ru.andrey.demotextrpg.logic.data.Location
import ru.andrey.demotextrpg.logic.data.Model
import ru.andrey.demotextrpg.logic.data.Stat
import ru.andrey.demotextrpg.logic.data.State
import ru.andrey.demotextrpg.ui.model.ActionUi
import ru.andrey.demotextrpg.ui.model.DirectionUi
import ru.andrey.demotextrpg.ui.model.InfoUi
import ru.andrey.demotextrpg.ui.model.LocationUi
import ru.andrey.demotextrpg.ui.model.ModelUi
import ru.andrey.demotextrpg.ui.model.StatUi
import ru.andrey.demotextrpg.ui.model.StateUi

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