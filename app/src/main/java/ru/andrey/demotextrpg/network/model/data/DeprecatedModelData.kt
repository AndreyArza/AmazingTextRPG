package ru.andrey.demotextrpg.network.model.data

import ru.andrey.demotextrpg.logic.data.Model
import kotlinx.serialization.Serializable

@Serializable
data class ModelData (
    val locationId: String,
    val stateId: String,
    val statsWithValuesIds: List<StatWithValueData>,
)
@Serializable
data class DeprecatedModelData (
    val locationId: String,
    val stateId: String,
    val info: DeprecatedInfoData,
){
    fun transform(allStats: List<DeprecatedStatData>, allStatsValues: List<DeprecatedStatValueData>) =
        Model(
            locationId= locationId,
            stateId = stateId,
            info = info.transform(allStats, allStatsValues )
        )
}



