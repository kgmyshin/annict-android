package com.kgmyshin.workDictionary.infra.api

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

internal class WorkDictionaryApiClientFactory {

    fun create(): WorkDictionaryApiClient {
        return Retrofit.Builder()
                .baseUrl("https://api.annict.com")
                .client(okhttp3.OkHttpClient())
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setDateFormat("yyyy-MM-dd").create()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(WorkDictionaryApiClient::class.java)
    }

}