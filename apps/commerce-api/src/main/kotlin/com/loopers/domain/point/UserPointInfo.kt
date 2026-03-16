package com.loopers.domain.point

import java.math.BigDecimal

object UserPointInfo {

    data class MyPoint(
        val userId: Long,
        val amount: BigDecimal
    ) {

        companion object {
            operator fun invoke(userPoint: UserPoint): MyPoint =
                MyPoint(userPoint.userId, userPoint.balance.value)
        }
    }

}
