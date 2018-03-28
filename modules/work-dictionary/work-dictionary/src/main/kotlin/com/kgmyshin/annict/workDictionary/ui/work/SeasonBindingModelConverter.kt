package com.kgmyshin.annict.workDictionary.ui.work

import com.kgmyshin.annict.workDictionary.domain.work.Season
import java.util.regex.Pattern

internal object SeasonBindingModelConverter {

    fun convertToViewModel(season: Season): SeasonBindingModel =
            SeasonBindingModel(
                    name = convertToViewName(season.name),
                    identifierName = season.name
            )

    fun convertToViewName(seasonIdentifierName: String): String {
        val p = Pattern.compile("(.*)-(.*)")
        val m = p.matcher(seasonIdentifierName)
        if (m.find()) {
            val seasonViewName = when (m.group(2)) {
                "spring" -> "春"
                "summer" -> "夏"
                "autumn" -> "秋"
                "winter" -> "冬"
                else -> ""
            }
            return "${m.group(1)}年$seasonViewName"
        } else {
            throw IllegalArgumentException("can't convert from $seasonIdentifierName")
        }
    }

}