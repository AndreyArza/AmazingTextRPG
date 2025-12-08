package ru.andrey.demotextrpg.network.model.data

data class PageData<T>(
    val values: List<T>,
    val loaded: Int,
    val total: Int
)