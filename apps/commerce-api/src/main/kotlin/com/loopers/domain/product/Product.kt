package com.loopers.domain.product

import com.loopers.domain.BaseEntity
import com.loopers.domain.product.vo.LikeCount
import com.loopers.domain.product.vo.ProductStatusType
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.Table
import jakarta.persistence.Version
import java.time.LocalDateTime

@Entity
@Table(name = "product")
class Product private constructor(
    brandId: Long,
    name: String,
    saleStartAt: LocalDateTime,
    status: ProductStatusType = ProductStatusType.ACTIVE,
): BaseEntity() {
    var brandId: Long = brandId
        private set

    var name: String = name
        private set

    var saleStartAt: LocalDateTime = saleStartAt
        private set

    var items: ProductItems = ProductItems()
        private set

    var likeCount: LikeCount = LikeCount.ZERO
        private set

    @Version
    var version: Long = 0
        private set

    @Enumerated(EnumType.STRING)
    var status: ProductStatusType = status
        private set

    fun increaseLikeCount() {
        likeCount++
    }

    fun decreaseLikeCount() {
        likeCount--
    }


}
