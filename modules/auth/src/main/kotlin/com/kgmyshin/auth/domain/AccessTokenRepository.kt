package com.kgmyshin.auth.domain

import io.reactivex.Completable
import io.reactivex.Single

internal interface AccessTokenRepository {

    fun find(): Single<AccessToken>

    fun store(accessToken: AccessToken): Completable

}