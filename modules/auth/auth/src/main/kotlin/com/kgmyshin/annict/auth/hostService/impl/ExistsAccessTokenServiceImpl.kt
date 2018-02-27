package com.kgmyshin.annict.auth.hostService.impl

import com.kgmyshin.annict.auth.hostService.ExistsAccessTokenService
import com.kgmyshin.annict.auth.usecase.ExistsAccessTokenUseCase
import io.reactivex.Single

internal class ExistsAccessTokenServiceImpl(private val usecase: ExistsAccessTokenUseCase) : ExistsAccessTokenService {
    override fun execute(): Single<Boolean> = usecase.execute()
}