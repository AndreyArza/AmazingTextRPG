package ru.andrey.demotextrpg.network.model.data

import ru.andrey.demotextrpg.logic.data.State
import kotlinx.serialization.Serializable

@Serializable
data class StateData(
    val id: String,
    val description: String,
)

@Serializable
data class DeprecatedStateData(
    val id: String,
    val description: String,
    val actionsIds: List<String> = listOf(),
) {
    fun transform(allActions: List<DeprecatedActionData>): State {
        return State(
            id = id,
            description = description,
            actions = actionsIds.map { id -> allActions.first { it.id == id }.transform() }
        )
    }
}


