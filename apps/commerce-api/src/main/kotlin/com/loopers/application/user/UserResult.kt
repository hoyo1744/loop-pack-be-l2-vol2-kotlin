package com.loopers.application.user

import com.loopers.domain.user.UserInfo

object UserResult {
    data class DetailProfile(
        val loginId: String,
        val email: String,
        val birthDay: String,
    ) {
        companion object {
            operator fun invoke(detailProfile: UserInfo.DetailProfile): DetailProfile =
                DetailProfile(
                    detailProfile.loginId,
                    detailProfile.email,
                    detailProfile.birthDay,
                )
        }
    }

    data class Profile(
        val loginId: String,
        val password: String,
        val email: String,
        val birthDay:String
    ){
        companion object {
            operator fun invoke(profile: UserInfo.Profile): Profile =
                Profile(profile.loginId, profile.password,profile.email, profile.birthDay)
        }
    }
}
