package com.loopers.domain.user.vo

import jakarta.persistence.Column
import jakarta.persistence.Embeddable

@Embeddable
data class Password protected constructor(
    @Column(name = "password")
    val value: String = ""
) {
    companion object {
        private val PASSWORD_REGEX = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#\$%^&*()_+\\-=]).{8,20}$".toRegex()

        operator fun invoke(value: String): Password {
            require(value.isBlank() || PASSWORD_REGEX.matches(value)) {
                "Password는 영문 소문자, 대문자, 숫자, 특수 문자의 조합이어야합니다."
            }
            return Password(value)
        }

    }
}
