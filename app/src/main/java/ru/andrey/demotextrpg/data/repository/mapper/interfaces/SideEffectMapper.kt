package ru.andrey.demotextrpg.data.repository.mapper.interfaces

import ru.andrey.demotextrpg.network.model.data.SideEffectData
import ru.andrey.demotextrpg.data.repository.model.Game
import ru.andrey.demotextrpg.data.repository.model.Model

interface SideEffectMapper: Mapper<SideEffectData, Unit, (Game, Model) -> Model>