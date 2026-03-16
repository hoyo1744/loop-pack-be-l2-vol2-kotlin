package com.loopers.application.point

import com.loopers.domain.point.UserPointService
import com.loopers.domain.user.UserService
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import java.math.BigDecimal

@Component
@Transactional(readOnly = true)
class PointFacade(
    val pointService: UserPointService,
    val userService: UserService
) {

    fun getBalance(loginId: String) : UserPointResult.MyPointBalance{
        val user = userService.getUserProfile(loginId)
        val userPoint = pointService.getUserPoint(user.userId)
        return UserPointResult.MyPointBalance(userPoint.amount)
    }

    fun chargePoint(loginId: String, amount: BigDecimal): UserPointResult.MyChargeBalance {
        val user = userService.getUserProfile(loginId)
        val chargedBalance = pointService.chargePoint(user.userId, amount)
        return UserPointResult.MyChargeBalance(chargedBalance)
    }
}
