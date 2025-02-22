package com.ssak3.timeattack.member.repository

import com.ssak3.timeattack.member.domain.Member
import com.ssak3.timeattack.member.domain.OAuthProvider

interface MemberRepositoryCustom {
    fun findByProviderAndSubject(
        oauthProvider: OAuthProvider,
        subject: String,
    ): Member?
}
