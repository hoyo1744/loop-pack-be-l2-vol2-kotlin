package com.loopers.application.point

import java.math.BigDecimal

class UserPointResult {

    data class MyPointBalance(
        val balance: BigDecimal
    )

    data class MyChargeBalance(
        val balance: BigDecimal
    )
}
