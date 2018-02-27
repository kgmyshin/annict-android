package com.kgmyshin.annict.auth.infra.domain

import com.kgmyshin.annict.auth.domain.AccessToken
import com.kgmyshin.annict.auth.domain.AuthorizeService
import com.kgmyshin.annict.auth.infra.api.AuthApiClient
import com.kgmyshin.annict.auth.infra.api.json.PublishTokenRequestJson
import io.reactivex.Scheduler
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Named

class AuthorizeServiceImpl @Inject constructor(
        private val apiClient: AuthApiClient,
        @Named("io") private val ioScheduler: Scheduler
) : AuthorizeService {

    override fun execute(code: String): Single<AccessToken> =
            apiClient.publishToken(PublishTokenRequestJson(code))
                    .map { AccessTokenConverter.convertToDomainModel(it) }
                    .subscribeOn(ioScheduler)

}