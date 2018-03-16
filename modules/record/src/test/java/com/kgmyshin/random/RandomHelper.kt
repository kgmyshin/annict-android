package com.kgmyshin.random

import java.util.*
import java.util.concurrent.ThreadLocalRandom

object RandomHelper {
    private val random: Random = Random()

    fun randomString() = UUID.randomUUID().toString()
    fun randomInt() = random.nextInt()
    fun randomBoolean() = random.nextBoolean()
    fun randomLong() = random.nextLong()
    fun randomDouble() = random.nextDouble()
    fun randomFloat() = random.nextFloat()
    fun randomDate() = Date(
            ThreadLocalRandom.current().nextLong(
                    Calendar.getInstance().apply {
                        set(
                                Calendar.YEAR,
                                2000
                        )
                        set(
                                Calendar.MONTH,
                                0
                        )
                        set(
                                Calendar.DAY_OF_MONTH,
                                1
                        )
                    }.timeInMillis,
                    Calendar.getInstance().timeInMillis
            )
    )
}
