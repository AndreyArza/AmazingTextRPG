package ru.andrey.demotextrpg.domain.model

data class Direction(
    val id: String,
    val name: String,
    val destinationId: String,
    val isVisible: (Model) -> Boolean,
)