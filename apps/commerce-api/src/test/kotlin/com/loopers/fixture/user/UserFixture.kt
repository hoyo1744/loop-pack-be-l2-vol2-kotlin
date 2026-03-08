package com.loopers.fixture.user

import com.loopers.domain.user.User

sealed class UserFixture(
    val loginId: String = "loginId",
    val password: String = "1q2w3e4R!@",
    val email: String = "email@domain.com",
    val birthDay: String = "2026-01-01"
) {
    data object 기본 : UserFixture()
    data object `특수문자를 사용한 ID` : UserFixture(loginId = "loginId!")
    data object `잘못된 형식의 생년월일`: UserFixture(birthDay = "19995-01-01")
    data object `오늘 날짜보다 앞선 생년월일`: UserFixture(birthDay = "3000-01-01")
    data object `잘못된 형식의 이메일`: UserFixture(email = "email@domain")



    fun toEntity() : User = User(loginId, password, email, birthDay)

    companion object {
        fun create(
            loginId: String,
            password: String,
            email: String = "email@domain.com",
            birthDay: String = "2026-01-01"
        ) : User = User(loginId, password, email, birthDay)
    }
}
