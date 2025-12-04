package ru.andrey.demotextrpg.data.repository.mapper.interfaces

import ru.andrey.demotextrpg.network.model.data.LocationData
import ru.andrey.demotextrpg.data.repository.model.Direction
import ru.andrey.demotextrpg.data.repository.model.Location

interface LocationMapper: Mapper<LocationData, List<Direction>, Location>