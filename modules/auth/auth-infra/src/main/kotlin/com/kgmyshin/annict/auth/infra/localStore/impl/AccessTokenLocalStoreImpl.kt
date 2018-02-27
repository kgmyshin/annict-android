package com.kgmyshin.annict.auth.infra.localStore.impl

import com.kgmyshin.annict.auth.infra.localStore.AccessTokenLocalStore
import com.kgmyshin.annict.auth.infra.pref.AccessTokenPreference
import io.reactivex.Completable
import io.reactivex.Maybe

internal class AccessTokenLocalStoreImpl(private val accessTokenPreference: AccessTokenPreference) : AccessTokenLocalStore {

    override fun get(): Maybe<String> = Maybe.create { source ->
        val accessToken = accessTokenPreference.get()
        if (accessToken is String) {
            source.onSuccess(accessToken)
        } else {
            source.onComplete()
        }
    }

    override fun put(accessToken: String): Completable = Completable.create { source ->

        accessTokenPreference.put(accessToken)
        source.onComplete()
    }
}