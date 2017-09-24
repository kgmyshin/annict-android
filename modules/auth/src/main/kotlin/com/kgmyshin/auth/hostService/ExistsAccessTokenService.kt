package com.kgmyshin.auth.hostService

import io.reactivex.Single

interface ExistsAccessTokenService {

    fun execute(): Single<Boolean>

}