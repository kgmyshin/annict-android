package com.kgmyshin.auth.infra.localStore

import io.reactivex.Completable
import io.reactivex.Single

internal interface AccessTokenLocalStore {

    fun get(): Single<String>

    fun put(accessToken: String): Completable

}