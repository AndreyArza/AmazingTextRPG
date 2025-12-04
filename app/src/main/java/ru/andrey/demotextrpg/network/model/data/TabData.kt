package ru.andrey.demotextrpg.network.model.data

import kotlinx.serialization.Serializable

@Serializable
data class TabData (
    val tabName: String,
    val isVisible: Boolean
)
