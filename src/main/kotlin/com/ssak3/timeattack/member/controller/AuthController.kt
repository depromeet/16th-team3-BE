package com.ssak3.timeattack.member.controller

import com.ssak3.timeattack.common.security.JwtTokenDto
import com.ssak3.timeattack.member.domain.Member
import com.ssak3.timeattack.member.service.AuthService
import jakarta.servlet.http.HttpServletResponse
import org.springframework.http.ResponseEntity
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/oauth")
class AuthController(
    private val authService: AuthService,
) {
    @PostMapping("/login")
    fun socialLogin(
        @RequestBody loginRequest: LoginRequest,
        response: HttpServletResponse,
    ): ResponseEntity<JwtTokenDto> {
        // 소셜 로그인 후, JWT 토큰 반환
        val tokens = authService.authenticateAndRegister(loginRequest)

        return ResponseEntity.ok(tokens)
    }

    // SecurityContextHolder & JwtAuthenticationFilter 동작 확인 API
    @GetMapping("/test")
    fun testFilter(
        @AuthenticationPrincipal member: Member,
    ): Member = member
}
