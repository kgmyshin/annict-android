package com.kgmyshin.auth.usecase

import io.reactivex.Completable

internal interface AuthorizeUseCase {

    fun execute(code: String): Completable

}