package com.kgmyshin.auth.usecase.impl

import com.kgmyshin.auth.domain.AccessToken
import com.kgmyshin.auth.domain.AccessTokenRepository
import com.kgmyshin.auth.usecase.GetAccessTokenUseCase
import io.reactivex.Maybe

internal class GetAccessTokenUseCaseImpl(private val repository: AccessTokenRepository) : GetAccessTokenUseCase {

    override fun execute(): Maybe<AccessToken> = repository.find()

}