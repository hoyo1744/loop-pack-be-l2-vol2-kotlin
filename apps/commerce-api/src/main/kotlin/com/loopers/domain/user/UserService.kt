package com.loopers.domain.user

import com.loopers.domain.user.vo.LoginId
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository
){
    fun getUserProfile(loginId: String) : UserInfo.DetailProfile {
        return userRepository.findByLoginId(LoginId(loginId))?.let {
            UserInfo.DetailProfile(it)
        } ?: throw IllegalArgumentException("로그인 ID가 ${loginId}에 해당하는 정보가 존재하지 않습니다.")
    }

    fun signUp(user: User) : UserInfo.Profile {
        check(!userRepository.existUserByLoginId(user.loginId)) { "이미 ${user.loginId}는 존재하는 계정입니다." }
        return userRepository.save(user).let{ UserInfo.Profile(it)}
    }
}
