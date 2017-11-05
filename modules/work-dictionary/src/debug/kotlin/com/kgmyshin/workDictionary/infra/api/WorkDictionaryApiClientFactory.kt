package com.kgmyshin.workDictionary.infra.api

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

internal class WorkDictionaryApiClientFactory {

    fun create(): WorkDictionaryApiClient {
        val loggerInterceptor = HttpLoggingInterceptor()
        loggerInterceptor.level = HttpLoggingInterceptor.Level.BASIC;
        val okHttpClient = OkHttpClient.Builder().addInterceptor(loggerInterceptor).build()
        return Retrofit.Builder()
                .baseUrl("https://api.annict.com")
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setDateFormat("yyyy-MM-dd").create()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(WorkDictionaryApiClient::class.java)
    }

}