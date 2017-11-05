package com.kgmyshin.record.infra.api

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

internal class RecordApiClientFactory {

    fun create(): RecordApiClient {
        return Retrofit.Builder()
                .baseUrl("https://api.annict.com")
                .client(OkHttpClient())
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setDateFormat("yyyy-MM-dd").create()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(RecordApiClient::class.java)
    }

}