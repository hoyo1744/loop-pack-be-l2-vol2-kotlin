package com.loopers.interfaces.api.point

import com.loopers.application.point.PointFacade
import com.loopers.interfaces.api.ApiResponse
import com.loopers.interfaces.api.auth.LoginId
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/points")
class PointV1Controller(
    val pointFacade: PointFacade
): PointV1ApiSpec {

    override fun getBalance(@LoginId loginId: String): ApiResponse<PointResponse.MyPointBalance> {
        return ApiResponse.success(PointResponse.MyPointBalance(pointFacade.getBalance(loginId).balance))
    }

    override fun chargePoint(@LoginId loginId: String, @RequestBody amount: PointRequest.Amount): ApiResponse<PointResponse.MyChargedResult>{
        return ApiResponse.success(PointResponse.MyChargedResult(pointFacade.chargePoint(loginId, amount.amount).balance))
    }
}
