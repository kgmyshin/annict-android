package com.kgmyshin.auth.infra

import android.app.Application
import com.kgmyshin.auth.infra.api.AuthApiClient
import com.kgmyshin.auth.infra.api.AuthApiClientFactory
import com.kgmyshin.auth.infra.localStore.AccessTokenLocalStore
import com.kgmyshin.auth.infra.localStore.impl.AccessTokenLocalStoreImpl
import com.kgmyshin.auth.infra.pref.AccessTokenPreference
import dagger.Module
import dagger.Provides

@Module
internal class AuthInfraModule {

    @Provides
    fun provideAccessTokenLocalStore(application: Application): AccessTokenLocalStore =
            AccessTokenLocalStoreImpl(AccessTokenPreference(application))

    @Provides
    fun provideAuthApiClient(): AuthApiClient = AuthApiClientFactory().create()

}

