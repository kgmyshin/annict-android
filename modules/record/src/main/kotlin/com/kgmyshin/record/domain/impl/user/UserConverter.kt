package com.kgmyshin.record.domain.impl.user

import com.kgmyshin.record.domain.user.User
import com.kgmyshin.record.domain.user.UserId
import com.kgmyshin.record.infra.api.json.UserJson

internal object UserConverter {

    fun convertToUser(json: UserJson): User =
            User(
                    id = UserId(json.id),
                    name = json.username
            )

}