package com.kgmyshin.annict.auth.infra.api

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class AuthApiClientFactory {

    fun create(): AuthApiClient {
        val loggerInterceptor = HttpLoggingInterceptor()
        loggerInterceptor.level = HttpLoggingInterceptor.Level.BODY;
        val okHttpClient = OkHttpClient.Builder().addInterceptor(loggerInterceptor).build()
        return Retrofit.Builder()
                .baseUrl("https://api.annict.com")
                .client(okHttpClient)
                .addConverterFactory(
                        GsonConverterFactory.create(
                                GsonBuilder().setDateFormat("YYYY-MM-DD'T'HH:MM:SS'Z'").create()
                        )
                )
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(AuthApiClient::class.java)
    }


}

