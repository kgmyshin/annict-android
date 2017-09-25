package com.kgmyshin.common.rx

import io.reactivex.Maybe

fun <T> Maybe<T>.exists() = isEmpty.map { !it }