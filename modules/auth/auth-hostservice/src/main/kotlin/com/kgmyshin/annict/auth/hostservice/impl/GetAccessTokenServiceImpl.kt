package com.kgmyshin.annict.auth.hostservice.impl

import com.kgmyshin.annict.auth.hostservice.GetAccessTokenService
import com.kgmyshin.annict.auth.usecase.GetAccessTokenUseCase
import io.reactivex.Single

internal class GetAccessTokenServiceImpl(private val usecase: GetAccessTokenUseCase) : GetAccessTokenService {

    override fun execute(): Single<String> = usecase.execute().toSingle().map { it.value }

}