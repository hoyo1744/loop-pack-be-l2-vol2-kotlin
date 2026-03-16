package com.loopers.domain.point

import com.loopers.domain.BaseEntity
import com.loopers.domain.point.vo.Point
import jakarta.persistence.Embedded
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = "user_point")
class UserPoint private constructor(
    userId: Long,
    balance: Point
): BaseEntity() {
    var userId: Long = userId
        private set

    @Embedded
    var balance: Point = balance
        private set

    fun charge(amount: Point) {

        this.balance += amount
    }

    fun deduct(amount: Point) {
        if( balance < amount) {
            throw IllegalStateException("잔여포인트 보다 사용 포인트가 더 많습니다.")
        }

        this.balance -= amount
    }

    companion object {
        operator fun invoke(
            userId: Long,
            balance: Point
        ): UserPoint = UserPoint(userId, balance)
    }


}
