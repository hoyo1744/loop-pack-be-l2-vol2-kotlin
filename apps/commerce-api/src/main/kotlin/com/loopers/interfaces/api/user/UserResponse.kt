package com.loopers.interfaces.api.user

import com.loopers.application.user.UserResult

object UserResponse {

    data class MyDetail(
        val loginId: String,
        val email: String,
        val birthDay: String
    ) {
        companion object {
            operator fun invoke(detailProfile: UserResult.DetailProfile) : MyDetail =
                MyDetail(
                    loginId = detailProfile.loginId, email = detailProfile.email,  birthDay = detailProfile.birthDay
                )
        }
    }

    data class Profile(
        val userId: String,
        val password: String,
        val email: String,
        val birthDay: String
    ) {
        companion object {
            operator fun invoke(profile: UserResult.Profile): Profile =
                Profile(
                    profile.loginId,
                    profile.password,
                    profile.email,
                    profile.birthDay
                    )
        }

    }
}
