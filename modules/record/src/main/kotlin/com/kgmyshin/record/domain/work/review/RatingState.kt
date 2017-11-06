package com.kgmyshin.record.domain.work.review

internal enum class RatingState(val rawValue: String) {
    Bad("bad"),
    Average("average"),
    Good("good"),
    Great("great");

    companion object {
        fun rawValueOf(rawValue: String): RatingState = when (rawValue) {
            RatingState.Bad.rawValue -> RatingState.Bad
            RatingState.Average.rawValue -> RatingState.Average
            RatingState.Good.rawValue -> RatingState.Good
            RatingState.Great.rawValue -> RatingState.Great
            else -> throw IllegalArgumentException("illegal argument $rawValue")
        }
    }
}
