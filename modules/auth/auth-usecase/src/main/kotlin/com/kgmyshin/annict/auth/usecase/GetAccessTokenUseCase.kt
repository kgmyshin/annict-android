package com.kgmyshin.annict.auth.usecase

import com.kgmyshin.annict.auth.domain.AccessToken
import io.reactivex.Maybe

interface GetAccessTokenUseCase {

    fun execute(): Maybe<AccessToken>

}