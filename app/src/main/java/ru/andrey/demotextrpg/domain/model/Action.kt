package ru.andrey.demotextrpg.domain.model

data class Action(
    val id: String,
    val description: String,
    val sideEffect: (Pair<List<Stat>, List<StatValue>>, Model) -> Model,
    val failSideEffect: (Pair<List<Stat>, List<StatValue>>, Model) -> Model = sideEffect,
    val isVisible: (Model) -> Boolean,
    val successCheck: (Model) -> Boolean,
)