package ru.andrey.demotextrpg.network.model.data

import kotlinx.serialization.Serializable
import ru.andrey.demotextrpg.logic.data.DeprecatedStatValue

@Serializable
data class StatValueData(
    val id: String,
    val statId: String,
    val value: String = "",
    val type: StatTypeData = StatTypeData.STRING,
)

@Serializable
data class DeprecatedStatValueData(
    val id: String,
    val statId: String,
    val value: String,
) {
    fun transform() =
        DeprecatedStatValue(
            id = id,
            statId = statId,
            value = value
        )
}
