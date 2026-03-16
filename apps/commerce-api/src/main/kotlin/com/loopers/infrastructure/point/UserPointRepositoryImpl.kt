package com.loopers.infrastructure.point

import com.loopers.domain.point.UserPoint
import com.loopers.domain.point.UserPointRepository
import org.springframework.stereotype.Repository

@Repository
class UserPointRepositoryImpl(
    private val userPointJpaRepository: UserPointJpaRepository
): UserPointRepository {
    override fun save(userPoint: UserPoint): UserPoint {
        return userPointJpaRepository.save(userPoint)
    }

    override fun findByUserId(userId: Long): UserPoint? {
        return userPointJpaRepository.findByUserId(userId)
    }
}
