package com.loopers.domain.user.vo

import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import java.time.Clock
import java.time.LocalDate

@Embeddable
data class BirthDay protected constructor(
    @Column(name = "birth_day")
    val value: String = ""
) {
    companion object {
        private val BIRTHDAY_REGEX = "^\\d{4}-\\d{2}-\\d{2}$".toRegex()

        operator fun invoke(value: String, clock: Clock = Clock.systemDefaultZone()): BirthDay {
            require(BIRTHDAY_REGEX.matches(value)) { "잘못된 생년월일입니다." }

            val birthDate = LocalDate.parse(value)

            require(birthDate.isBefore(LocalDate.now(clock))) { "생년월일은 오늘 보다 작아야 합니다." }

            return BirthDay(value)
        }
    }
}
