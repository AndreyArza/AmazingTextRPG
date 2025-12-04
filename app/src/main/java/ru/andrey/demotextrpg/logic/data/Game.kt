package ru.andrey.demotextrpg.logic.data

data class Game(
    val allActions: Map<String, Action>,
    val allStates: Map<String, State>,
    val allLocations: Map<String, Location>,
    val allDirections: Map<String, Direction>,
    val allStats: Map<String, Stat>,
    val allStatsValues: Map<String, DeprecatedStatValue>,
    val initModel: Model
)