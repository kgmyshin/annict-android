package com.kgmyshin.annict.auth.usecase.impl

import com.kgmyshin.annict.auth.domain.AccessTokenRepository
import com.kgmyshin.annict.auth.usecase.ExistsAccessTokenUseCase
import io.reactivex.Single

internal class ExistsAccessTokenUseCaseImpl constructor(
        private val repository: AccessTokenRepository
) : ExistsAccessTokenUseCase {

    override fun execute(): Single<Boolean> = repository.exists()

}