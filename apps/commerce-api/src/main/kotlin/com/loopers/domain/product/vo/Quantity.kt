package com.loopers.domain.product.vo

@JvmInline
value class Quantity(val value: Int) {
    init {
        if (value < 0) {
            throw IllegalStateException("상품 개수는 0보다 작을 수 없습니다")
        }
    }
}
