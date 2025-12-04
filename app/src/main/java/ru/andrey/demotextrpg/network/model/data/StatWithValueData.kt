package ru.andrey.demotextrpg.network.model.data

import kotlinx.serialization.Serializable

@Serializable
data class StatWithValueData(
    val statId: String,
    val valueId: String,
)