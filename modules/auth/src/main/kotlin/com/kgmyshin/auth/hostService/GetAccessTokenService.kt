package com.kgmyshin.auth.hostService

import io.reactivex.Maybe

interface GetAccessTokenService {

    fun execute(): Maybe<String>

}