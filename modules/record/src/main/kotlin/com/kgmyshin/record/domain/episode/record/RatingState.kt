package com.kgmyshin.record.domain.episode.record

internal enum class RatingState(val rawValue: String) {
    Bad("bad"),
    Average("average"),
    Good("good"),
    Great("great");

    companion object {
        fun rawValueOf(rawValue: String): RatingState = when (rawValue) {
            Bad.rawValue -> Bad
            Average.rawValue -> Average
            Good.rawValue -> Good
            Great.rawValue -> Great
            else -> throw IllegalArgumentException("illegal argument $rawValue")
        }
    }
}