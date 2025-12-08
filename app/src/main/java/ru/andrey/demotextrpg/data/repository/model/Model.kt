package ru.andrey.demotextrpg.data.repository.model

data class Model(
    val locationId: String,
    val stateId: String,
    val stats: Map<Stat, StatValue>,
)