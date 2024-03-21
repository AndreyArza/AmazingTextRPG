package com.example.witcheriv.data.model

import com.example.witcheriv.logic.data.Stat
import kotlinx.serialization.Serializable

@Serializable
data class StatData(
    val id: String,
    val order: Int,
    val name: String,
) {
    fun transform(statsValues: List<StatValueData>) =
        Stat(
            id = id,
            order = order,
            name = name,
            values = statsValues.map(StatValueData::transform).filter { it.statId == id }.toMutableSet()
        )
}

