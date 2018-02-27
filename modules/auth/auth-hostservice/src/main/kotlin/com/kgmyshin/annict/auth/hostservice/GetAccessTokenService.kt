package com.kgmyshin.annict.auth.hostservice

import io.reactivex.Single

interface GetAccessTokenService {

    fun execute(): Single<String>

}