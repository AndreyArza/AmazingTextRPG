package ru.andrey.demotextrpg.network.model.data

import kotlinx.serialization.Serializable

@Serializable
data class StatValueData(
    val id: String,
    val statId: String,
    val value: String = "",
    val type: StatTypeData = StatTypeData.STRING,
)