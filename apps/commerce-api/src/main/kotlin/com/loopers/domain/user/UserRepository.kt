package com.loopers.domain.user

import com.loopers.domain.user.vo.LoginId

interface UserRepository {
    fun findByLoginId(loginId: LoginId): User?
    fun existUserByLoginId(loginId: LoginId): Boolean
    fun save(user: User): User
}
