package com.kgmyshin.auth.usecase.impl

import com.kgmyshin.auth.domain.AccessTokenRepository
import com.kgmyshin.auth.domain.AuthorizeService
import com.kgmyshin.auth.usecase.AuthorizeUseCase
import io.reactivex.Completable

internal class AuthorizeUseCaseImpl(
        private val authorizeService: AuthorizeService,
        private val accessTokenRepository: AccessTokenRepository
) : AuthorizeUseCase {

    override fun execute(code: String): Completable =
            authorizeService.execute(code)
                    .flatMapCompletable { accessTokenRepository.store(it) }
}