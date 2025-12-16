package ru.andrey.demotextrpg.data.repository.mapper.interfaces

import ru.andrey.demotextrpg.domain.model.Game
import ru.andrey.demotextrpg.network.model.data.GameData

interface GameMapper : Mapper<GameData, Unit, Game>