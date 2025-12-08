package ru.andrey.demotextrpg.data.repository.mapper.implementation

import ru.andrey.demotextrpg.data.repository.mapper.interfaces.ModelMapper
import ru.andrey.demotextrpg.data.repository.mapper.interfaces.StatMapper
import ru.andrey.demotextrpg.data.repository.mapper.interfaces.StatValueMapper
import ru.andrey.demotextrpg.data.repository.model.Model
import ru.andrey.demotextrpg.data.repository.model.Stat
import ru.andrey.demotextrpg.data.repository.model.StatValue
import ru.andrey.demotextrpg.network.model.data.ModelData
import ru.andrey.demotextrpg.network.model.data.StatData
import ru.andrey.demotextrpg.network.model.data.StatValueData

class ModelMapperImpl(
    val statMapper: StatMapper = StatMapperImpl(),
    val statValueMapper: StatValueMapper = StatValueMapperImpl()
) : ModelMapper {
    override fun map(
        data: ModelData,
        additionalInfo: Pair<List<StatData>, List<StatValueData>>?
    ): Model {
        val allStats = additionalInfo?.first ?: listOf()
        val allStatsValues = additionalInfo?.second ?: listOf()
        val newStats = mutableMapOf<Stat, StatValue>()
        for (statWithValue in data.statsWithValuesIds) {
            val statData =
                allStats.firstOrNull { it.id == statWithValue.statId } ?: continue
            val stat = statMapper.map(statData)
            val statValueData =
                allStatsValues.firstOrNull { it.id == statWithValue.valueId } ?: continue
            val statValue = statValueMapper.map(statValueData)
            newStats[stat] = statValue
        }

        return Model(
            locationId = data.locationId,
            stateId = data.stateId,
            stats = newStats
        )
    }
}
