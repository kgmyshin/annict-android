package com.kgmyshin.annict.auth.infra.domain

import com.kgmyshin.annict.auth.domain.AccessToken
import com.kgmyshin.annict.auth.infra.api.json.PublishTokenResponseJson

internal object AccessTokenConverter {

    fun convertToDomainModel(json: PublishTokenResponseJson): AccessToken = AccessToken(json.accessToken)

}