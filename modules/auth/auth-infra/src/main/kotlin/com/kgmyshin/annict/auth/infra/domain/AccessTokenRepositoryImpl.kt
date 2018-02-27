package com.kgmyshin.annict.auth.infra.domain

import com.kgmyshin.annict.auth.domain.AccessToken
import com.kgmyshin.annict.auth.domain.AccessTokenRepository
import com.kgmyshin.annict.auth.infra.localStore.AccessTokenLocalStore
import com.kgmyshin.common.rx.exists
import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Single

class AccessTokenRepositoryImpl(private val accessTokenLocalStore: AccessTokenLocalStore) : AccessTokenRepository {

    override fun exists(): Single<Boolean> = accessTokenLocalStore.get().exists()

    override fun find(): Maybe<AccessToken> = accessTokenLocalStore.get().map { AccessToken(it) }

    override fun store(accessToken: AccessToken): Completable = accessTokenLocalStore.put(accessToken.value)
}