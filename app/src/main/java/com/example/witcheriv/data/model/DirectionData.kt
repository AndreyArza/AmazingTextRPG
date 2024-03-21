package com.example.witcheriv.data.model

import com.example.witcheriv.logic.data.Direction
import kotlinx.serialization.Serializable

@Serializable
data class DirectionData(
    val id: String,
    val name: String,
    val destinationId: String,

    // Перед отображением проверяется наличия флага в Info.hiddenFlagsIds
    // пустой список - проверка не проводится, действие видно всегда
    val visibilityFlagsIds: List<String> = listOf(),
) {
    fun transform() =
        Direction(
            id = id,
            name = name,
            destinationId = destinationId,
            isVisible = { model ->
                visibilityFlagsIds.all { model.info.hiddenFlagsIds.contains(it) }
            }
        )
}

