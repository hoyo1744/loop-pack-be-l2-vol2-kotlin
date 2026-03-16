package com.loopers.domain.product

import com.loopers.domain.BaseEntity
import com.loopers.domain.product.vo.Price
import com.loopers.domain.product.vo.Quantity
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Table(name = "product_item")
class ProductItem private constructor(
    product: Product,
    name: String,
    price: Price,
    quantity: Quantity,
): BaseEntity() {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    var product: Product = product
        private set

    var name: String = name
        private set

    var quantity: Quantity = quantity
        private set

    var price: Price = price
        private set
}
