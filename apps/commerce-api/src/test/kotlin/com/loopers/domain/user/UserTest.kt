package com.loopers.domain.user

import com.loopers.fixture.user.UserFixture
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class UserTest {

    @Nested
    inner class `회원 생성` {

        @Test
        fun `회원을 생성합니다`() {
            //given & when
            val user = UserFixture.기본.toEntity()

            //then
            assertThat(user.loginId.value).isEqualTo(UserFixture.기본.loginId)
            assertThat(user.email.value).isEqualTo(UserFixture.기본.email)
            assertThat(user.birthDay.value).isEqualTo(UserFixture.기본.birthDay)
        }

        @Test
        fun `회원ID에 특수문자를 사용한 경우 IllegalArgumentException이 발생합니다`() {
            assertThatIllegalArgumentException()
                .isThrownBy { UserFixture.`특수문자를 사용한 ID`.toEntity() }
                .withMessage("ID 포맷이 올바르지 않습니다.")
        }

        @Test
        fun `올바르지 않은 이메일 포맷 사용시 IllegalArgumentException이 발생합니다`() {
            assertThatIllegalArgumentException()
                .isThrownBy { UserFixture.`잘못된 형식의 이메일`.toEntity()}
                .withMessage("이메일 포맷이 올바르지 않습니다")
        }

        @Test
        fun `올바르지 않은 생년월일 포맷 입력시 IllegarArgumentException이 발생합니다`() {
            assertThatIllegalArgumentException()
                .isThrownBy { UserFixture.`잘못된 형식의 생년월일`.toEntity() }
                .withMessage("잘못된 생년월일입니다.")
        }

        @Test
        fun `생년월일이 오늘 날짜 보다 앞서는 경우 IllegalArgumentException이 발생합니다` () {
            assertThatIllegalArgumentException()
                .isThrownBy { UserFixture.`오늘 날짜보다 앞선 생년월일`.toEntity() }
                .withMessage("생년월일은 오늘 보다 작아야 합니다.")
        }

    }

}
