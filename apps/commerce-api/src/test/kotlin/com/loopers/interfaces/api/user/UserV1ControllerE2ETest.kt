package com.loopers.interfaces.api.user

import com.loopers.application.user.UserFacade
import com.loopers.fixture.user.UserFixture
import com.loopers.interfaces.api.ApiResponse
import com.loopers.support.error.E2ETestSupport
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertAll
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpEntity
import org.springframework.http.HttpMethod
import org.springframework.http.HttpStatus

class UserV1ControllerE2ETest(
    private val userFacade: UserFacade
): E2ETestSupport() {

    @Nested
    inner class `회원 등록` {

        @Test
        fun `회원 등록시 등록한 회원 정보를 반환합니다`() {
            //given
            val requestUrl = "/api/v1/users"
            val request = UserFixture.기본
            val responseType = object : ParameterizedTypeReference<ApiResponse<UserResponse.Profile>>(){}

            //when
            val result = testRestTemplate.exchange(requestUrl, HttpMethod.POST, HttpEntity(request), responseType)

            //then
            assertAll(
                { assertThat(result.statusCode).isEqualTo(HttpStatus.OK) },
                { assertThat(result.body?.data?.userId).isEqualTo(request.loginId)}

            )
        }
    }

    @Nested
    inner class `회원 조회` {
        @Test
        fun `loginId로 회원 정보 조회 시, 회원 정보를 반환합니다`() {
            //given
            val requestUrl = "/api/v1/users/me"
            val request = UserFixture.기본
            val responseType = object : ParameterizedTypeReference<ApiResponse<UserResponse.MyDetail>>(){}

            //when


            //then
        }
    }

}
