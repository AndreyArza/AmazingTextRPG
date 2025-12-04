package ru.andrey.demotextrpg.data.repository.mapper.interfaces

import ru.andrey.demotextrpg.network.model.data.GameData1
import ru.andrey.demotextrpg.network.model.data.ModelData
import ru.andrey.demotextrpg.data.repository.model.Model

interface ModelMapper: Mapper<ModelData, GameData1, Model>