package ru.andrey.demotextrpg.data.repository.mapper.interfaces

import ru.andrey.demotextrpg.network.model.data.GameData1
import ru.andrey.demotextrpg.data.repository.model.Game

interface GameMapper: Mapper<GameData1, Unit, Game>