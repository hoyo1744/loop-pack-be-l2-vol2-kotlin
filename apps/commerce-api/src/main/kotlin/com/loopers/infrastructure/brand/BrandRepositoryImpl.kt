package com.loopers.infrastructure.brand

import com.loopers.domain.brand.Brand
import com.loopers.domain.brand.BrandRepository
import com.loopers.domain.brand.vo.BrandStatusType
import org.springframework.stereotype.Repository

@Repository
class BrandRepositoryImpl(
    private val brandJpaRepository: BrandJpaRepository
): BrandRepository  {

    override fun findActiveBrandById(id: Long): Brand? =
        brandJpaRepository.findAll {
            select(
                entity(Brand::class)
            ).from(
                entity(Brand::class)
            ).whereAnd(
                path(Brand::id).eq(id),
                path(Brand::status).eq(BrandStatusType.ACTIVUE),
                path(Brand::deletedAt).isNull()
            )
        }.firstOrNull()
}
