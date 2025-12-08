package ru.andrey.demotextrpg.network.model.data

import kotlinx.serialization.Serializable

@Serializable
data class SideEffectData(
    val newStateId: String? = null,
    val newLocationId: String? = null,
    val statEvents: List<StatEventData> = listOf(),
)