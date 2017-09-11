package com.kgmyshin.auth.infra.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

internal class AuthApiClientFactory {

    fun create(): AuthApiClient =
            Retrofit.Builder()
                    .baseUrl("https://api.annict.com")
                    .client(OkHttpClient())
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build()
                    .create(AuthApiClient::class.java)


}