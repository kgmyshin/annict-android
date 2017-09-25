package com.kgmyshin.auth.usecase.impl

import com.kgmyshin.auth.domain.AccessTokenRepository
import com.kgmyshin.auth.usecase.ExistsAccessTokenUseCase
import io.reactivex.Single

internal class ExistsAccessTokenUseCaseImpl constructor(private val repository: AccessTokenRepository) : ExistsAccessTokenUseCase {

    override fun execute(): Single<Boolean> = repository.exists()

}