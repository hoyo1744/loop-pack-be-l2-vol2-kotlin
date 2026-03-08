package com.loopers.domain.user

import com.loopers.domain.BaseEntity
import com.loopers.domain.user.vo.BirthDay
import com.loopers.domain.user.vo.Email
import com.loopers.domain.user.vo.LoginId
import com.loopers.domain.user.vo.Password
import jakarta.persistence.Embedded
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = "user")
class User private constructor(
    loginId: LoginId,
    password: Password,
    email: Email,
    birthDay: BirthDay
) : BaseEntity() {
    @Embedded
    var loginId: LoginId = loginId
        private set

    @Embedded
    var password: Password = password
        private set

    @Embedded
    var email: Email = email
        private set

    @Embedded
    var birthDay: BirthDay = birthDay
        private set

    companion object {
        operator fun invoke(
            loginId: String,
            password: String,
            email: String,
            birthDay: String): User = User(
                LoginId(loginId),
                Password(password),
                Email(email),
                BirthDay(birthDay)
            )
    }
}
