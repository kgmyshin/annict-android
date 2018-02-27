package com.kgmyshin.annict.auth.usecase

import io.reactivex.Completable

interface AuthorizeUseCase {

    fun execute(code: String): Completable

}