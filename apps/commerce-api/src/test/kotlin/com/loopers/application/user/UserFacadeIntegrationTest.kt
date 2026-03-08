package com.loopers.application.user

import com.loopers.domain.user.UserRepository
import com.loopers.fixture.user.UserFixture
import com.loopers.support.error.IntegrationTestSupport
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class UserFacadeIntegrationTest(
    private val cut: UserFacade,
    private val userRepository: UserRepository

) : IntegrationTestSupport() {
    @Nested
    inner class `회원 정보 조회` {

        @Test
        fun `등록된 회원 정보를 조회한다`() {
            //given
            val user = UserFixture.기본.toEntity()
            userRepository.save(user)

            //when
            val result = cut.getDetailProfile(user.loginId.value)

            //then
            assertThat(user.loginId.value).isEqualTo(result.loginId)
        }
    }

    @Nested
    inner class `회원 등록` {

        @Test
        fun `회원 등록시, 회원 정보를 반환합니다`() {
            //given
            val fixture = UserFixture.기본
            val signUp = UserCommand.SignUp(fixture.loginId, fixture.password, fixture.email, fixture.birthDay)


            //when
            val result = cut.signUp(signUp)

            //then
            assertThat(signUp.loginId).isEqualTo(result.loginId)
            assertThat(signUp.email).isEqualTo(result.email)
            assertThat(signUp.birthDay).isEqualTo(result.birthDay)
        }
    }

}
