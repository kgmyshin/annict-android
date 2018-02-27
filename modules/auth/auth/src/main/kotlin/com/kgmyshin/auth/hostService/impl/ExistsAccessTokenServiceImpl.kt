package com.kgmyshin.auth.hostService.impl

import com.kgmyshin.auth.hostService.ExistsAccessTokenService
import com.kgmyshin.auth.usecase.ExistsAccessTokenUseCase
import io.reactivex.Single

internal class ExistsAccessTokenServiceImpl(private val usecase: ExistsAccessTokenUseCase) : ExistsAccessTokenService {
    override fun execute(): Single<Boolean> = usecase.execute()
}