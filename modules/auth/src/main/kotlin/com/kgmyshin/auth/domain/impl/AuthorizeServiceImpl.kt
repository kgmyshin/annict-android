package com.kgmyshin.auth.domain.impl

import com.kgmyshin.auth.domain.AccessToken
import com.kgmyshin.auth.domain.AuthorizeService
import com.kgmyshin.auth.infra.api.AuthApiClient
import com.kgmyshin.auth.infra.api.json.PublishTokenRequestJson
import io.reactivex.Scheduler
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Named

internal class AuthorizeServiceImpl @Inject constructor(
        private val apiClient: AuthApiClient,
        @Named("io") private val ioScheduler: Scheduler
) : AuthorizeService {

    override fun execute(code: String): Single<AccessToken> =
            apiClient.publishToken(PublishTokenRequestJson(code))
                    .map { AccessTokenConverter.convertToDomainModel(it) }
                    .subscribeOn(ioScheduler)

}