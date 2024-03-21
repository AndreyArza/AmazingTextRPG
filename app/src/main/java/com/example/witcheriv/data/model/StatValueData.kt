package com.example.witcheriv.data.model

import com.example.witcheriv.logic.data.StatValue
import kotlinx.serialization.Serializable


@Serializable
data class StatValueData(
    val id: String,
    val statId: String,
    val value: String,
) {
    fun transform() =
        StatValue(
            id = id,
            statId = statId,
            value = value
        )
}
