package com.kgmyshin.workDictionary.domain.work

import com.kgmyshin.common.dddSupport.ValueObject
import java.util.*

internal class Season(val name: String) : ValueObject {

    companion object {

        fun thisSeason(): Season {
            val c = Calendar.getInstance()
            return Season(toSeasonName(c))
        }

        fun nextSeason(): Season {
            val c = Calendar.getInstance()
            c.add(
                    Calendar.MONTH,
                    3
            )
            return Season(toSeasonName(c))
        }

        fun beforeSeason(): Season {
            val c = Calendar.getInstance()
            c.add(
                    Calendar.MONTH,
                    -3
            )
            return Season(toSeasonName(c))
        }


        private fun toSeasonName(calendar: Calendar): String {
            val seasonStr = when (calendar.get(Calendar.MONTH) + 1) {
                1, 2, 3 -> "spring"
                4, 5, 6 -> "summer"
                7, 8, 9 -> "autumn"
                10, 11, 12 -> "winter"
                else -> throw IllegalArgumentException("invalid calendar")
            }
            return "${calendar.get(Calendar.YEAR)}-$seasonStr"
        }

    }

}