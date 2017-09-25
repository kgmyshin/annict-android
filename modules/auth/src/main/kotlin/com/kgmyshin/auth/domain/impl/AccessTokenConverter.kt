package com.kgmyshin.auth.domain.impl

import com.kgmyshin.auth.domain.AccessToken
import com.kgmyshin.auth.infra.api.json.PublishTokenResponseJson

internal object AccessTokenConverter {

    fun convertToDomainModel(json: PublishTokenResponseJson): AccessToken = AccessToken(json.accessToken)

}