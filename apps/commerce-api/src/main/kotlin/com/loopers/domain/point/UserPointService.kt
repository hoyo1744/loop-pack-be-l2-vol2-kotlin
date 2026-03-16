package com.loopers.domain.point

import com.loopers.domain.point.vo.Point
import org.springframework.stereotype.Service
import java.math.BigDecimal

@Service
class UserPointService(
    private val userPointRepository: UserPointRepository
) {

    private fun getUserPointEntity(userId: Long): UserPoint {
        return userPointRepository.findByUserId(userId)
            ?: throw IllegalStateException("회원 식별자 ${userId}는 존재하지 않는 회원 식별자입니다.")
    }

    fun getUserPoint(userId: Long): UserPointInfo.MyPoint {
        return UserPointInfo.MyPoint(getUserPointEntity(userId))
    }

    fun chargePoint(userId: Long, amount: BigDecimal): BigDecimal {
        val userPoint = getUserPointEntity(userId)
        userPoint.charge(Point(amount))
        return userPoint.balance.value
    }

    fun createInitialPoint(userId: Long): UserPointInfo.MyPoint {
        val userPoint = UserPoint(userId, Point(BigDecimal.ZERO))
        userPointRepository.save(userPoint)
        return UserPointInfo.MyPoint(userPoint)
    }
}
