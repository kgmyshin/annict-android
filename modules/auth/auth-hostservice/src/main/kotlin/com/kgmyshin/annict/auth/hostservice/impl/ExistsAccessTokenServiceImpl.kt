package com.kgmyshin.annict.auth.hostservice.impl

import com.kgmyshin.annict.auth.hostservice.ExistsAccessTokenService
import com.kgmyshin.annict.auth.usecase.ExistsAccessTokenUseCase
import io.reactivex.Single

internal class ExistsAccessTokenServiceImpl(private val usecase: ExistsAccessTokenUseCase) : ExistsAccessTokenService {
    override fun execute(): Single<Boolean> = usecase.execute()
}