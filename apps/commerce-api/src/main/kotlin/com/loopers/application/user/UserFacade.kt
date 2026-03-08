package com.loopers.application.user

import com.loopers.domain.user.UserService
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
@Transactional(readOnly = true)
class UserFacade(
    private val userService : UserService
){
    fun getDetailProfile(loginId: String) : UserResult.DetailProfile {
        return UserResult.DetailProfile(userService.getUserProfile(loginId))
    }

    @Transactional
    fun signUp(user: UserCommand.SignUp): UserResult.Profile {
        return UserResult.Profile(userService.signUp(user.toEntity()))
    }

}
