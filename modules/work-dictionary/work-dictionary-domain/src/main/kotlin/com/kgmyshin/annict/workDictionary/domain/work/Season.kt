package com.kgmyshin.annict.workDictionary.domain.work

import com.kgmyshin.common.dddSupport.ValueObject
import java.util.*

data class Season(val name: String) : ValueObject {

    companion object {

        private const val MONTHS_OF_ONE_SEASON = 3
        private val SPRING = 1..3
        private val SUMMER = 4..6
        private val AUTUMN = 7..9
        private val WINTER = 10..12

        fun thisSeason(): Season {
            val c = Calendar.getInstance()
            return Season(toSeasonName(c))
        }

        fun nextSeason(): Season {
            val c = Calendar.getInstance()
            c.add(
                    Calendar.MONTH,
                    MONTHS_OF_ONE_SEASON
            )
            return Season(toSeasonName(c))
        }

        fun beforeSeason(): Season {
            val c = Calendar.getInstance()
            c.add(
                    Calendar.MONTH,
                    -MONTHS_OF_ONE_SEASON
            )
            return Season(toSeasonName(c))
        }


        private fun toSeasonName(calendar: Calendar): String {
            val seasonStr = when (calendar.get(Calendar.MONTH) + 1) {
                in SPRING -> "spring"
                in SUMMER -> "summer"
                in AUTUMN -> "autumn"
                in WINTER -> "winter"
                else -> throw IllegalArgumentException("invalid calendar")
            }
            return "${calendar.get(Calendar.YEAR)}-$seasonStr"
        }

    }

}