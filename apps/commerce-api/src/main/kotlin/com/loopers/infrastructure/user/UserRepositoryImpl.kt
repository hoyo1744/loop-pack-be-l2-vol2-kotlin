package com.loopers.infrastructure.user

import com.loopers.domain.user.User
import com.loopers.domain.user.UserRepository
import com.loopers.domain.user.vo.LoginId
import org.springframework.stereotype.Repository

@Repository
class UserRepositoryImpl
    (
    private val userJpaRepository: UserJpaRepository
): UserRepository {
    override fun findByLoginId(loginId: LoginId): User? {
        return userJpaRepository.findByLoginId(loginId)
    }

    override fun existUserByLoginId(loginId: LoginId): Boolean {
        return userJpaRepository.existsUserByLoginId(loginId)
    }

    override fun save(user: User): User {
        return userJpaRepository.save(user)
    }
}
