package ru.andrey.demotextrpg.network.model.data

import ru.andrey.demotextrpg.logic.data.Stat
import kotlinx.serialization.Serializable

@Serializable
enum class StatTypeData{
    STRING,
    INT,
    FLOAT,
    BOOLEAN,
}




@Serializable
data class StatData(
    val id: String,
    val name: String = "",
    val sortField: Int = Int.MAX_VALUE,
    val isVisible: Boolean = true,
) {
//    fun transform(statsValues: List<StatValueData>) =
//        Stat(
//            id = id,
//            order = order,
//            name = name,
//            values = statsValues.map(StatValueData::transform).filter { it.statId == id }.toMutableSet()
//        )
}
@Serializable
data class DeprecatedStatData(
    val id: String,
    val order: Int,
    val name: String,
) {
    fun transform(statsValues: List<DeprecatedStatValueData>) =
        Stat(
            id = id,
            order = order,
            name = name,
            values = statsValues.map(DeprecatedStatValueData::transform).filter { it.statId == id }.toMutableSet()
        )
}

