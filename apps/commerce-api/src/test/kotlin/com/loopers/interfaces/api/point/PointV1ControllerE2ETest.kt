package com.loopers.interfaces.api.point

import com.loopers.application.point.PointFacade
import com.loopers.application.user.UserCommand
import com.loopers.application.user.UserFacade
import com.loopers.fixture.user.UserFixture
import com.loopers.interfaces.api.ApiResponse
import com.loopers.support.error.E2ETestSupport
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.http.HttpStatus
import java.math.BigDecimal

class PointV1ControllerE2ETest(
    val pointFacade: PointFacade,
    val userFacade: UserFacade
): E2ETestSupport() {

    @Nested
    inner class `포인트 조회` {
        private val requestUrl = "/api/v1/points"

        @Test
        fun `포인트 조회시, 잔여 포인트를 반환합니다`() {
            //given
            val userFixture = UserFixture.기본
            val signUpUser = userFacade.signUp(
                UserCommand.SignUp(
                    userFixture.loginId,
                    userFixture.password,
                    userFixture.email,
                    userFixture.birthDay
                )
            )
            val headers = HttpHeaders()
            headers["X-USER-ID"] = signUpUser.loginId
            val httpRequest = HttpEntity<Any>(headers)
            val responseType = object : ParameterizedTypeReference<ApiResponse<PointResponse.MyPointBalance>>(){}


            //when
            val result = testRestTemplate.exchange(requestUrl, HttpMethod.GET, httpRequest, responseType)


            //then
            Assertions.assertAll(
                { assertThat(result.statusCode).isEqualTo(HttpStatus.OK)},
                { assertThat(result.body?.data?.balance).isEqualTo(BigDecimal("0.00"))},
            )
        }

    }


    @Nested
    inner class `포인트 충전` {

        @Test
        fun `포인트 충전시, 충전 포인트를 정보를 반환합니다`() {
            //given

            //when

            //then
        }


    }


}
