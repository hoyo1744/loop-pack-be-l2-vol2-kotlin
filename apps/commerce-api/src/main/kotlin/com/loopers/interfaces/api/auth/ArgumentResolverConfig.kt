package com.loopers.interfaces.api.auth

import org.springframework.context.annotation.Configuration
import org.springframework.web.method.support.HandlerMethodArgumentResolver
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class ArgumentResolverConfig : WebMvcConfigurer {
    override fun addArgumentResolvers(resolvers: List<HandlerMethodArgumentResolver?>) {
        resolvers.plus(LoginIdArgumentResolver())
    }
}
