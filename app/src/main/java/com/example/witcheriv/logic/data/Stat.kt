package com.example.witcheriv.logic.data

data class Stat(
    val id: String,
    val order: Int,
    val name: String,
    val values: MutableSet<StatValue>
)