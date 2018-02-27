package com.kgmyshin.annict.auth.infra.api

import com.kgmyshin.annict.auth.infra.api.json.PublishTokenRequestJson
import com.kgmyshin.annict.auth.infra.api.json.PublishTokenResponseJson
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApiClient {

    @POST("/oauth/token")
    fun publishToken(@Body req: PublishTokenRequestJson): Single<PublishTokenResponseJson>

}