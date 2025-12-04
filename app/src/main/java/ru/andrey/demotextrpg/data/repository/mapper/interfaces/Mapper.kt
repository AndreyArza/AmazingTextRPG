package ru.andrey.demotextrpg.data.repository.mapper.interfaces

interface Mapper<T,V,R> {
    fun map(data: T, additionalInfo: V? = null): R
}