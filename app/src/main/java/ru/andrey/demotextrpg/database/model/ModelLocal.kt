package ru.andrey.demotextrpg.database.model

data class ModelLocal(
    val locationId: String,
    val stateId: String,
    val statsWithValuesIds: List<StatWithValueLocal>,
)



