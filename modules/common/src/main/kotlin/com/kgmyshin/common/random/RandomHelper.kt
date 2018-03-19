package com.kgmyshin.common.random

import java.util.*

object RandomHelper {
    private val random: Random = Random()

    fun randomString() = UUID.randomUUID().toString()
    fun randomInt() = random.nextInt()
    fun randomBoolean() = random.nextBoolean()
    fun randomLong() = random.nextLong()
    fun randomDouble() = random.nextDouble()
    fun randomFloat() = random.nextFloat()
    fun randomDate() = Date(
            Calendar.getInstance().apply {
                set(
                        Calendar.YEAR,
                        2000 + random.nextInt(100)
                )
                set(
                        Calendar.MONTH,
                        random.nextInt(12)
                )
                set(
                        Calendar.DAY_OF_MONTH,
                        random.nextInt(29)
                )
            }.timeInMillis
    )
}
