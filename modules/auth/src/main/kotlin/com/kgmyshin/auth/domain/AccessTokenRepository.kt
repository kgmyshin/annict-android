package com.kgmyshin.auth.domain

import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Single

internal interface AccessTokenRepository {

    fun exists(): Single<Boolean>

    fun find(): Maybe<AccessToken>

    fun store(accessToken: AccessToken): Completable

}