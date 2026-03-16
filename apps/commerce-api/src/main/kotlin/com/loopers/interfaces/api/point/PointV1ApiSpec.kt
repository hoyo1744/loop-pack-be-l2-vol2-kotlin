package com.loopers.interfaces.api.point

import com.loopers.interfaces.api.ApiResponse
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

@Tag(name = "Point API", description = "Point API")
interface PointV1ApiSpec{
    @GetMapping
    @Operation(
        summary = "포인트 조회",
        description = "회원 ID 식별자로 보유 포인트를 조회합니다."

    )
    fun getBalance(
        @Schema(name = "loginId", description = "logindId", example = "hoyong.eom")
        loginId: String): ApiResponse<PointResponse.MyPointBalance>

    @PostMapping
    @Operation(
        summary = "포인트 충전",
        description = "금액을 입력받아 포인트를 충전합니다."
    )
    fun chargePoint(
        @Schema(name = "loginId", description = "logindId", example = "hoyong.eom")
        loginId: String,

        @Schema(name = "amount", description = "logindId", example = "hoyong.eom")
        @RequestBody amount: PointRequest.Amount
    ) : ApiResponse<PointResponse.MyChargedResult>
}
