package ru.andrey.demotextrpg.data.repository.mapper.interfaces

import ru.andrey.demotextrpg.domain.model.Direction
import ru.andrey.demotextrpg.domain.model.Location
import ru.andrey.demotextrpg.network.model.data.LocationData

interface LocationMapper : Mapper<LocationData, List<Direction>, Location>