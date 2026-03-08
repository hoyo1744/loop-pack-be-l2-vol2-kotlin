package com.loopers.interfaces.api.user

import com.loopers.application.user.UserFacade
import com.loopers.interfaces.api.ApiResponse
import com.loopers.interfaces.api.auth.LoginId
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/users")
class UserV1Controller(
    private val userFacade: UserFacade
) : UserV1ApiSpec {

    @GetMapping("/me")
    override fun getMyDetailProfile(@LoginId loginId: String): ApiResponse<UserResponse.MyDetail> {
        return ApiResponse.success(UserResponse.MyDetail(userFacade.getDetailProfile(loginId)))
    }

    @PostMapping
    override fun signUpUser(@RequestBody signUp: UserRequest.SignUp): ApiResponse<UserResponse.Profile> {
        return ApiResponse.success(UserResponse.Profile(userFacade.signUp(signUp.toCommand())))
    }
}
