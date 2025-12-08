package ru.andrey.demotextrpg.database.type_converter

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import ru.andrey.demotextrpg.database.custom_types.RelationActionToStatsType

@ProvidedTypeConverter
class RelationActionToStatsTypeTypeConverter {
    @TypeConverter
    fun to(value: String): RelationActionToStatsType = RelationActionToStatsType.valueOf(value)

    @TypeConverter
    fun from(value: RelationActionToStatsType): String = value.name
}