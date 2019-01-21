package com.jfboily.canbeer.security

import org.apache.tomcat.websocket.AuthenticationException
import javax.servlet.http.HttpServletResponse
import javax.servlet.http.HttpServletRequest
import org.springframework.security.web.AuthenticationEntryPoint
import org.springframework.stereotype.Component


@Component
class RestAuthenticationEntryPoint : AuthenticationEntryPoint {

    override fun commence(
            request: HttpServletRequest,
            response: HttpServletResponse,
            authException: AuthenticationException) {

        response.sendError(HttpServletResponse.SC_UNAUTHORIZED,
                "Unauthorized")
    }
}