package com.loopers.interfaces.api.point

import java.math.BigDecimal

object PointRequest {
    data class Amount(
        val amount: BigDecimal
    )
}
