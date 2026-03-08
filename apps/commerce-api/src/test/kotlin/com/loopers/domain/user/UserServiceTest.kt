package com.loopers.domain.user

import com.loopers.domain.user.vo.LoginId
import com.loopers.fixture.user.UserFixture
import io.mockk.every
import io.mockk.mockk
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class UserServiceTest {

    private val userRepository: UserRepository = mockk()
    private val userService = UserService(userRepository)

    @Nested
    inner class `회원 정보 조회` {
        @Test
        fun `존재하지 않는 회원 조회 시 IllegalArgumentException 예외가 발생합니다`() {
            //given
            val loginId = UserFixture.기본.loginId
            every { userRepository.findByLoginId(LoginId(loginId)) } returns null

            //when & then
            assertThatIllegalArgumentException()
                .isThrownBy { userService.getUserProfile(loginId) }
                .withMessage("로그인 ID가 ${loginId}에 해당하는 정보가 존재하지 않습니다.")
        }

        @Test
        fun `회원 가입된 유저를 조회합니다`() {
            //given
            val user = UserFixture.기본.toEntity()
            val loginId = user.loginId.value
            every { userRepository.findByLoginId(LoginId(loginId)) } returns user

            //when
            val result = userService.getUserProfile(loginId)

            //then
            assertThat(result.loginId).isEqualTo(user.loginId.value)
            assertThat(result.email).isEqualTo(user.email.value)
            assertThat(result.birthDay).isEqualTo(user.birthDay.value)
        }
    }


    @Nested
    inner class `회원 생성` {

        @Test
        fun `이미 생성된 계정인 경우 IllegalStateException 예외를 발생합니다`() {
            //given
            val user = UserFixture.기본.toEntity()

            //when
            every { userRepository.existUserByLoginId(user.loginId)} returns true

            //then
            assertThatIllegalStateException()
                .isThrownBy { userService.signUp(user) }
                .withMessage("이미 ${user.loginId}는 존재하는 계정입니다.")
        }

        @Test
        fun `회원을 등록합니다`() {
            //given
            val user = UserFixture.기본.toEntity()
            every { userRepository.existUserByLoginId(user.loginId) } returns false
            every { userRepository.save(user) } returns user

            //when
            val result = userService.signUp(user)

            //then
            assertThat(result.loginId).isEqualTo(user.loginId.value)
            assertThat(result.email).isEqualTo(user.email.value)
            assertThat(result.birthDay).isEqualTo(user.birthDay.value)
        }

    }

}
