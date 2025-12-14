package ru.andrey.demotextrpg.database.model

data class SideEffectLocal(
    val newStateId: String? = null,
    val newLocationId: String? = null,
    val statEvents: List<StatEventLocal> = listOf(),
)