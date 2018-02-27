package com.kgmyshin.annict.auth.hostService

import io.reactivex.Single

interface GetAccessTokenService {

    fun execute(): Single<String>

}