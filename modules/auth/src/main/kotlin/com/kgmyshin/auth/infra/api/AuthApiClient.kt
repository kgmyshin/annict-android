package com.kgmyshin.auth.infra.api

import com.kgmyshin.auth.infra.api.json.GetTokenInfoResponseJson
import com.kgmyshin.auth.infra.api.json.PublishTokenRequestJson
import com.kgmyshin.auth.infra.api.json.PublishTokenResponseJson
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

internal interface AuthApiClient {

    @POST("/oauth/token")
    fun publishToken(@Body req: PublishTokenRequestJson): Single<PublishTokenResponseJson>

}