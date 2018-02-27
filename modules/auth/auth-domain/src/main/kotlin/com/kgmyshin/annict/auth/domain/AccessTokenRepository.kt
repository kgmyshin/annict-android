package com.kgmyshin.annict.auth.domain

import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Single

interface AccessTokenRepository {

    fun exists(): Single<Boolean>

    fun find(): Maybe<AccessToken>

    fun store(accessToken: AccessToken): Completable

}