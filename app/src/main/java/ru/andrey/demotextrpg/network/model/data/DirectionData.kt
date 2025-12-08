package ru.andrey.demotextrpg.network.model.data

import kotlinx.serialization.Serializable

@Serializable
data class DirectionData(
    val id: String,
    val name: String,
    val destinationId: String,
    val visibilityRequiredStats: List<StatWithValueData> = listOf(),
)