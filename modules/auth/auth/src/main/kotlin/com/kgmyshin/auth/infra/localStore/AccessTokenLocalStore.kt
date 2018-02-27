package com.kgmyshin.auth.infra.localStore

import io.reactivex.Completable
import io.reactivex.Maybe

internal interface AccessTokenLocalStore {

    fun get(): Maybe<String>

    fun put(accessToken: String): Completable

}