package com.loopers.domain.product.vo


@JvmInline
value class LikeCount(val value: Long) {
    operator fun inc(): LikeCount = LikeCount(value + 1)
    operator fun dec(): LikeCount = LikeCount(value - 1)

    fun isZero(): Boolean = this == ZERO

    init {
        if (value < 0) {
            throw IllegalStateException("좋아요 개수는 0보다 작을 수 없습니다.")
        }
    }

    companion object {
        val ZERO = LikeCount(0L)
    }

}
