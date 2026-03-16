package com.loopers.domain.point.vo

import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import java.math.BigDecimal

@Embeddable
data class Point protected constructor(
    @Column(name = "point")
    val value: BigDecimal
){
    init {
        if ( value < BigDecimal.ZERO) {
            throw IllegalStateException("포인트를 항상 0 보다 커야합니다.")
        }
    }

    companion object {
        operator fun invoke(value: BigDecimal): Point {
            return Point(value)
        }
    }

    operator fun plus(other: Point) = Point(value + other.value)
    operator fun minus(other: Point) = Point(value - other.value)
    operator fun compareTo(other: Point): Int = value.compareTo(other.value)
}
