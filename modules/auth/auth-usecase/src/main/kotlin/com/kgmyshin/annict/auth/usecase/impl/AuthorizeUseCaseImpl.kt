package com.kgmyshin.annict.auth.usecase.impl

import com.kgmyshin.annict.auth.domain.AccessTokenRepository
import com.kgmyshin.annict.auth.domain.AuthorizeService
import com.kgmyshin.annict.auth.usecase.AuthorizeUseCase
import io.reactivex.Completable

internal class AuthorizeUseCaseImpl(
        private val authorizeService: AuthorizeService,
        private val accessTokenRepository: AccessTokenRepository
) : AuthorizeUseCase {

    override fun execute(code: String): Completable =
            authorizeService.execute(code)
                    .flatMapCompletable { accessTokenRepository.store(it) }
}