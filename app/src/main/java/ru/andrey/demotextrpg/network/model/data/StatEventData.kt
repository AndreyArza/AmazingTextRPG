package ru.andrey.demotextrpg.network.model.data

import kotlinx.serialization.Serializable

@Serializable
data class StatEventData(
    val statId: String,
    val statValueId: String,
    val type: StatEventTypeData,
)