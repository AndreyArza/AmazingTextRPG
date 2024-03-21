package com.example.witcheriv.logic.data

data class Direction(
    val id: String,
    val name: String,
    val destinationId: String,
    val isVisible: (Model) -> Boolean,
)