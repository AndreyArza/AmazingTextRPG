package ru.andrey.demotextrpg.data.repository.model

data class Direction(
    val id: String,
    val name: String,
    val destinationId: String,
    val isVisible: (Model) -> Boolean,
)