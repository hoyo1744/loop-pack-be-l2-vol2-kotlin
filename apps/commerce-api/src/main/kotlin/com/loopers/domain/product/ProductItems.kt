package com.loopers.domain.product

import jakarta.persistence.Embeddable

@Embeddable
class ProductItems(
    @
    val items: MutableList<ProductItem> = mutableListOf<>()
) {
}
