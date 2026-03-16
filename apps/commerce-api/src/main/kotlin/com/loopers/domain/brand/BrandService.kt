package com.loopers.domain.brand

import org.springframework.stereotype.Service

@Service
class BrandService(
    private val brandRepository: BrandRepository
) {
    fun getActiveBrandDetail(id: Long): BrandInfo.BrandDetail {
        return brandRepository.findActiveBrandById(id)?.let { BrandInfo.BrandDetail(it) }
            ?: throw IllegalArgumentException("브랜드(${id}가 존재하지 않습니다.")
    }
}
