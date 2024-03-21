package com.example.witcheriv.data.model

import com.example.witcheriv.logic.data.State
import kotlinx.serialization.Serializable

@Serializable
data class StateData(
    val id: String,
    val description: String,
    val actionsIds: List<String> = listOf(),
) {
    fun transform(allActions: List<ActionData>): State {
        return State(
            id = id,
            description = description,
            actions = actionsIds.map { id -> allActions.first { it.id == id }.transform() }
        )
    }
}


