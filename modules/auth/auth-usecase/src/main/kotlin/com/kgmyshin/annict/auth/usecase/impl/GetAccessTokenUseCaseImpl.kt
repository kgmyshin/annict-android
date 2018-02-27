package com.kgmyshin.annict.auth.usecase.impl

import com.kgmyshin.annict.auth.domain.AccessToken
import com.kgmyshin.annict.auth.domain.AccessTokenRepository
import com.kgmyshin.annict.auth.usecase.GetAccessTokenUseCase
import io.reactivex.Maybe

internal class GetAccessTokenUseCaseImpl(private val repository: AccessTokenRepository) : GetAccessTokenUseCase {

    override fun execute(): Maybe<AccessToken> = repository.find()

}