package com.kgmyshin.auth.usecase

import com.kgmyshin.auth.domain.AccessToken
import io.reactivex.Maybe

internal interface GetAccessTokenUseCase {

    fun execute(): Maybe<AccessToken>

}