package com.kgmyshin.annict.auth.usecase

import io.reactivex.Single

interface ExistsAccessTokenUseCase {

    fun execute(): Single<Boolean>

}