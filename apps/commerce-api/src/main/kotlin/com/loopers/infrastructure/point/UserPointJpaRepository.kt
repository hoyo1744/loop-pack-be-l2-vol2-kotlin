package com.loopers.infrastructure.point

import com.loopers.domain.point.UserPoint
import org.springframework.data.jpa.repository.JpaRepository

interface UserPointJpaRepository: JpaRepository<UserPoint, Long> {
    fun findByUserId(userId: Long): UserPoint?
}
