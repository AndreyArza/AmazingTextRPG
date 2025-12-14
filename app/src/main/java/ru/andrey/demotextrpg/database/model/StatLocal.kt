package ru.andrey.demotextrpg.database.model

data class StatLocal(
    val id: String,
    val name: String = "",
    val sortField: Int = Int.MAX_VALUE,
    val isVisible: Boolean = true,
)

