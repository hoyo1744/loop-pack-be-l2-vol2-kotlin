package com.loopers.infrastructure.user

import com.loopers.domain.user.User
import com.loopers.domain.user.vo.LoginId
import org.springframework.data.jpa.repository.JpaRepository

interface UserJpaRepository : JpaRepository<User, Long>{
    fun findByLoginId(loginId: LoginId): User?
    fun existsUserByLoginId(loginId: LoginId): Boolean
}
