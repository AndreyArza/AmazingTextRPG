package ru.andrey.demotextrpg.logic.data

data class Action(
    val id: String,
    val description: String,
    val sideEffect: (Game, Model) -> Model,
    val failSideEffect: (Game, Model) -> Model = sideEffect,
    val isVisible: (Model) -> Boolean,
    val successCheck: (Model) -> Boolean,
)