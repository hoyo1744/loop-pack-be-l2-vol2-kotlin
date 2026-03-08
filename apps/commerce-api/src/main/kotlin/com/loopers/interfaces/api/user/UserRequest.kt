package com.loopers.interfaces.api.user

import com.loopers.application.user.UserCommand

object UserRequest {
    data class SignUp(
        val loginId: String,
        val password: String,
        val email: String,
        val birthDay: String,
    ) {
        fun toCommand(): UserCommand.SignUp =
            UserCommand.SignUp(loginId = loginId, password = password, email = email, birthDay = birthDay)
    }
}
