package com.loopers.domain.user.vo

import jakarta.persistence.Column
import jakarta.persistence.Embeddable

@Embeddable
data class Email protected constructor(
    @Column(name = "email")
    val value: String = ""
) {
    companion object {
        private val EMAIL_REGEX = "^[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.[a-zA-Z0-9]+$".toRegex()

        operator fun invoke(value: String): Email{
            if (value.isNotBlank() && !EMAIL_REGEX.matches(value)) {
                throw IllegalArgumentException("이메일 포맷이 올바르지 않습니다")
            }

            return Email(value)
        }


    }
}
