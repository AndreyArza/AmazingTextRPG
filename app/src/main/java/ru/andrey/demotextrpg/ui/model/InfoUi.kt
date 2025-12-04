package ru.andrey.demotextrpg.ui.model

data class InfoUi(
    val stats: List<StatUi>
) {
    override fun toString(): String {
        val sortedStats = stats.sortedBy { it.order }
        var result = ""
        stats.forEach {
            result = result + it.name + ": " + it.values.joinToString(", ") + "\n"
        }
        return result
    }
}

