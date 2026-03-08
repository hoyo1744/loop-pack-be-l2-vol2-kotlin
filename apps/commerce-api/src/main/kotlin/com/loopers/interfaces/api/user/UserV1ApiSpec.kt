package com.loopers.interfaces.api.user

import com.loopers.interfaces.api.ApiResponse
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.tags.Tag

@Tag(name = "User API", description = "User API")
interface UserV1ApiSpec {

    @Operation(
        summary = "회원 조회",
        description = "ID로 회원을 조회합니다."
    )
    fun getMyDetailProfile(
        @Schema(name = "id", description = "User ID", example = "hoyong.eom")
        loginId: String) : ApiResponse<UserResponse.MyDetail>


    @Operation(
        summary = "회원 가입",
        description = "id, password, name, birthDate 정보를 입력받아 회원 정보를 등록합니다."
    )
    fun signUpUser(
        signUp : UserRequest.SignUp
    ) : ApiResponse<UserResponse.Profile>
}
