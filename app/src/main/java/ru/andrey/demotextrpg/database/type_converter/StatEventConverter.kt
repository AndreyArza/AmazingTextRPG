package ru.andrey.demotextrpg.database.type_converter

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import ru.andrey.demotextrpg.database.custom_types.StatEventType

@ProvidedTypeConverter
class StatEventConverter {
    @TypeConverter
    fun toStatEvent(value: String): StatEventType = StatEventType.valueOf(value)

    @TypeConverter
    fun fromStatEvent(value: StatEventType): String = value.name
}