package ru.andrey.demotextrpg.network.model.request

import kotlinx.serialization.Serializable

@Serializable
data class CountData(
    val count: Int
)