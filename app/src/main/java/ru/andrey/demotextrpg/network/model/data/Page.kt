package ru.andrey.demotextrpg.network.model.data

data class Page<T> (
    val values: List<T>,
    val loaded: Int,
    val total: Int
)