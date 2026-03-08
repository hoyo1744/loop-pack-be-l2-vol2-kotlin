package com.loopers.domain.user.vo

import jakarta.persistence.Column
import jakarta.persistence.Embeddable

@Embeddable
data class LoginId protected constructor(
    @Column(name = "login_id")
    val value: String = ""
) {
    companion object {
        private val USER_ID_REGEX = "^[a-zA-Z0-9]{6,10}$".toRegex()

        operator fun invoke(value: String) : LoginId {
            if (value.isNotBlank() && !USER_ID_REGEX.matches(value)) {
                throw IllegalArgumentException("ID 포맷이 올바르지 않습니다.")
            }
            return LoginId(value)
        }

    }
}
