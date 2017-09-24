package com.kgmyshin.auth.domain.impl

import com.kgmyshin.auth.domain.AccessToken
import com.kgmyshin.auth.domain.AccessTokenRepository
import com.kgmyshin.auth.infra.localStore.AccessTokenLocalStore
import io.reactivex.Completable
import io.reactivex.Single

internal class AccessTokenRepositoryImpl(private val accessTokenLocalStore: AccessTokenLocalStore) : AccessTokenRepository {

    override fun find(): Single<AccessToken> = accessTokenLocalStore.get().map { AccessToken(it) }

    override fun store(accessToken: AccessToken): Completable = accessTokenLocalStore.put(accessToken.value)
}