package ru.andrey.demotextrpg.network.model.data

import kotlinx.serialization.Serializable

@Serializable
data class SuccessCheckData(
    //Сравнение идет по id и value
    val requiredStats: List<StatWithValueData> = listOf(),
    val unsuccessfulStats: List<StatWithValueData> = listOf(),
)