package ru.andrey.demotextrpg.network.model.data

import kotlinx.serialization.Serializable

@Serializable
data class StateData(
    val id: String,
    val description: String,
)


