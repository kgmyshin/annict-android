package com.kgmyshin.annict.auth.infra.localStore

import io.reactivex.Completable
import io.reactivex.Maybe

interface AccessTokenLocalStore {

    fun get(): Maybe<String>

    fun put(accessToken: String): Completable

}