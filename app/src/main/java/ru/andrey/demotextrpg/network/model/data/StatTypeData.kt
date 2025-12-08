package ru.andrey.demotextrpg.network.model.data

import kotlinx.serialization.Serializable

@Serializable
enum class StatTypeData {
    STRING,
    INT,
    FLOAT,
    BOOLEAN,
}