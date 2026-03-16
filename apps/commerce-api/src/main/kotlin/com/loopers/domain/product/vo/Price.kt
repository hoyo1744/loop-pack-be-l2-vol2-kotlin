package com.loopers.domain.product.vo

import java.math.BigDecimal

@JvmInline
value class Price(val value: BigDecimal) {
    init {
        if (value < BigDecimal.ZERO) {
            throw IllegalStateException("가격은 음수일 수 없습니다.")
        }
    }
}
