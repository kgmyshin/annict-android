package com.kgmyshin.record.domain.user

import com.kgmyshin.common.dddSupport.Entity

internal class User(
        id: UserId,
        val name: String
) : Entity<UserId>(id)