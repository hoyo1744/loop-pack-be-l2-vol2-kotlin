package com.loopers.interfaces.api.point

import java.math.BigDecimal

object PointResponse {
    data class MyPointBalance(
        val balance: BigDecimal
    )

    data class MyChargedResult(
        val balance: BigDecimal
    )
}
