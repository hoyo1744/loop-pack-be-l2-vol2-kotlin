package com.loopers.domain.user

object UserInfo {
    data class DetailProfile(
        val loginId: String,
        val email: String,
        val birthDay: String,
    ) {
        companion object {
            operator fun invoke(user: User): DetailProfile =
                DetailProfile(
                    user.loginId.value, user.email.value, user.birthDay.value,
                )
        }
    }

    data class Profile(
        val loginId: String,
        val password: String,
        val email: String,
        val birthDay: String
    ) {
        companion object {
            operator fun invoke(user: User): Profile =
                Profile(user.loginId.value, user.password.value,
                    user.email.value, user.birthDay.value)
        }
    }
}
