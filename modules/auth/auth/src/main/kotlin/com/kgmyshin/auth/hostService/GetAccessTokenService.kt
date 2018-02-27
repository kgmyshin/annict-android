package com.kgmyshin.auth.hostService

import io.reactivex.Single

interface GetAccessTokenService {

    fun execute(): Single<String>

}