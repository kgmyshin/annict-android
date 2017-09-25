package com.kgmyshin.auth.usecase

import io.reactivex.Single

internal interface ExistsAccessTokenUseCase {

    fun execute(): Single<Boolean>

}