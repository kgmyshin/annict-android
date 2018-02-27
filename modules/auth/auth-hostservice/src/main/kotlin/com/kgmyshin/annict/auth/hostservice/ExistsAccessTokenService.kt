package com.kgmyshin.annict.auth.hostservice

import io.reactivex.Single

interface ExistsAccessTokenService {

    fun execute(): Single<Boolean>

}