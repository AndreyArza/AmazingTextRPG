package ru.andrey.demotextrpg.network.model.data

import kotlinx.serialization.Serializable

@Serializable
data class ModelData(
    val locationId: String,
    val stateId: String,
    val statsWithValuesIds: List<StatWithValueData>,
)



