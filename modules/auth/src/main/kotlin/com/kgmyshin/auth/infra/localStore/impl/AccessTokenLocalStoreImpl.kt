package com.kgmyshin.auth.infra.localStore.impl

import com.kgmyshin.auth.infra.localStore.AccessTokenLocalStore
import com.kgmyshin.auth.infra.localStore.NotFoundAccessTokenException
import com.kgmyshin.auth.infra.pref.AccessTokenPreference
import io.reactivex.Completable
import io.reactivex.Single

internal class AccessTokenLocalStoreImpl(private val accessTokenPreference: AccessTokenPreference) : AccessTokenLocalStore {

    override fun get(): Single<String> = Single.create { source ->
        val accessToken = accessTokenPreference.get()
        if (accessToken is String) {
            source.onSuccess(accessToken)
        } else {
            source.onError(NotFoundAccessTokenException())
        }
    }

    override fun put(accessToken: String): Completable = Completable.create { source ->
        accessTokenPreference.put(accessToken)
        source.onComplete()
    }
}