package com.loopers.domain.brand

object BrandInfo {
    data class BrandDetail(
        val name: String,
    ) {
        companion object {
            operator fun invoke(brand: Brand): BrandDetail =
                BrandDetail(brand.name)
        }
    }
}
