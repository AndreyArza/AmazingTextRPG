package com.example.witcheriv.data.model

import com.example.witcheriv.logic.data.Model
import kotlinx.serialization.Serializable

@Serializable
data class ModelData (
    val locationId: String,
    val stateId: String,
    val info: InfoData,
){
    fun transform(allStats: List<StatData>, allStatsValues: List<StatValueData>) =
        Model(
            locationId= locationId,
            stateId = stateId,
            info = info.transform(allStats, allStatsValues )
        )
}



