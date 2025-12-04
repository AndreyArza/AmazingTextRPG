package ru.andrey.demotextrpg.data.repository.mapper.implementation

import ru.andrey.demotextrpg.network.model.data.GameData1
import ru.andrey.demotextrpg.network.model.data.ModelData
import ru.andrey.demotextrpg.data.repository.mapper.interfaces.ModelMapper
import ru.andrey.demotextrpg.data.repository.mapper.interfaces.StatMapper
import ru.andrey.demotextrpg.data.repository.mapper.interfaces.StatValueMapper
import ru.andrey.demotextrpg.data.repository.model.Model
import ru.andrey.demotextrpg.data.repository.model.Stat
import ru.andrey.demotextrpg.data.repository.model.StatValue

class ModelMapperImpl(
    val statMapper: StatMapper = StatMapperImpl(),
    val statValueMapper: StatValueMapper = StatValueMapperImpl()
) : ModelMapper {
    override fun map(
        data: ModelData,
        additionalInfo: GameData1?
    ): Model {
        val stats = additionalInfo?.let { game ->
            val newStats = mutableMapOf<Stat, StatValue>()
            for (statWithValue in data.statsWithValuesIds) {
                val statData =
                    game.allStats.firstOrNull { it.id == statWithValue.statId } ?: continue
                val stat = statMapper.map(statData)
                val statValueData =
                    game.allStatsValues.firstOrNull { it.id == statWithValue.valueId } ?: continue
                val statValue = statValueMapper.map(statValueData)
                newStats[stat] = statValue
            }
            newStats
        } ?: mapOf()

        return Model(
            locationId = data.locationId,
            stateId = data.stateId,
            stats = stats
        )
    }
}
