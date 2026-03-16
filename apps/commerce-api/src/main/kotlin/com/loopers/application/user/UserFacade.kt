package com.loopers.application.user

import com.loopers.domain.point.UserPointService
import com.loopers.domain.user.UserService
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
@Transactional(readOnly = true)
class UserFacade(
    private val userService : UserService,
    private val userPointService: UserPointService

){
    fun getDetailProfile(loginId: String) : UserResult.DetailProfile {
        return UserResult.DetailProfile(userService.getUserProfile(loginId))
    }

    @Transactional
    fun signUp(user: UserCommand.SignUp): UserResult.Profile {
        val user = userService.signUp(user.toEntity())
        userPointService.createInitialPoint(user.userId)
        return UserResult.Profile(user.loginId, user.password, user.email, user.birthDay)
    }

}
