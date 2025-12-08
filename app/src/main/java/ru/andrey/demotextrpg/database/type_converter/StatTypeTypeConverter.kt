package ru.andrey.demotextrpg.database.type_converter

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import ru.andrey.demotextrpg.database.custom_types.StatType


@ProvidedTypeConverter
class StatTypeTypeConverter {
    @TypeConverter
    fun toStatType(value: String): StatType = StatType.valueOf(value)

    @TypeConverter
    fun fromStatType(value: StatType): String = value.name
}