package com.kgmyshin.auth.hostService.impl

import com.kgmyshin.auth.hostService.GetAccessTokenService
import com.kgmyshin.auth.usecase.GetAccessTokenUseCase
import io.reactivex.Maybe

internal class GetAccessTokenServiceImpl(private val usecase: GetAccessTokenUseCase) : GetAccessTokenService {

    override fun execute(): Maybe<String> = usecase.execute().map { it.value }

}