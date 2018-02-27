package com.kgmyshin.auth.domain

import io.reactivex.Single

internal interface AuthorizeService {

    fun execute(code: String): Single<AccessToken>

}