package ru.andrey.demotextrpg.data.repository.mapper.implementation

import ru.andrey.demotextrpg.data.repository.mapper.interfaces.GameMapper
import ru.andrey.demotextrpg.domain.model.Game
import ru.andrey.demotextrpg.domain.model.TabInfo
import ru.andrey.demotextrpg.network.model.data.GameData
import ru.andrey.demotextrpg.network.model.data.TabData

class GameMapperImpl() : GameMapper {
    override fun map(
        data: GameData,
        additionalInfo: Unit?
    ): Game {
        return Game(
            id = data.id,
            version = data.version,
            name = data.name,
            locationTabInfo = mapTabInfo(data.locationTabInfo),
            stateTabInfo = mapTabInfo(data.stateTabInfo),
            statsTabInfo = mapTabInfo(data.statsTabInfo)
        )
    }

    private fun mapTabInfo(data: TabData): TabInfo {
        return TabInfo(
            tabName = data.tabName,
            isVisible = data.isVisible
        )
    }
}