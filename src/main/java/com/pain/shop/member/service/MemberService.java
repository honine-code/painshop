package com.pain.shop.member.service;

import com.pain.shop.member.domain.Member;
import com.pain.shop.member.dto.MemberDto;

public interface MemberService {

    Long join(MemberDto memberDto);
    String login(String memberId, String password);
}
