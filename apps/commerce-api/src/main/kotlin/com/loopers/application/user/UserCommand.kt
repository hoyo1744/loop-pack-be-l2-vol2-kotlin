package com.loopers.application.user

import com.loopers.domain.user.User

object UserCommand {
    data class SignUp(
        val loginId: String,
        val password: String,
        val email: String,
        val birthDay: String
    ) {
        fun toEntity(): User = User(loginId = loginId, password = password, email = email, birthDay = birthDay )
    }
}
