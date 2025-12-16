package ru.andrey.demotextrpg.domain.model

data class Stat(
    val id: String,
    val name: String = "",
    val sortField: Int = Int.MAX_VALUE,
    val isVisible: Boolean = true,
)