package com.kgmyshin.auth.domain

import com.kgmyshin.common.dddSupport.ValueObject

data class AccessToken(val value: String) : ValueObject