package ru.andrey.demotextrpg.database.type_converter

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import ru.andrey.demotextrpg.database.custom_types.SideEffectType

@ProvidedTypeConverter
class SideEffectTypeTypeConverter {
    @TypeConverter
    fun to(value: String): SideEffectType = SideEffectType.valueOf(value)

    @TypeConverter
    fun from(value: SideEffectType): String = value.name
}