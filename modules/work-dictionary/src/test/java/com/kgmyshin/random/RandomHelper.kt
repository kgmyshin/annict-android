package com.kgmyshin.random

import java.util.Random
import java.util.UUID

object RandomHelper {
  private val random: Random = Random()

  fun randomString() = UUID.randomUUID().toString()
  fun randomInt() = random.nextInt()
  fun randomBoolean() = random.nextBoolean()
  fun randomLong() = random.nextLong()
  fun randomDouble() = random.nextDouble()
  fun randomFloat() = random.nextFloat()}
