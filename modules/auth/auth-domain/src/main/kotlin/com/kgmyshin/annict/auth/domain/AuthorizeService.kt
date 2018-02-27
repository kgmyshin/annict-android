package com.kgmyshin.annict.auth.domain

import io.reactivex.Single

interface AuthorizeService {

    fun execute(code: String): Single<AccessToken>

}