package com.pain.shop.member.service.impl;

import com.pain.shop.config.auth.CustomMemberDetails;
import com.pain.shop.member.dto.MemberDto;
import com.pain.shop.member.repository.MemberRepository;
import com.pain.shop.member.service.MemberDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberDetailServiceImpl implements MemberDetailService {

    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String memberId) throws UsernameNotFoundException {
        MemberDto memberDto = memberRepository.findByMemberId(memberId).orElseThrow(() -> new UsernameNotFoundException("해당 정보를 찾을 수 없습니다." + memberId));

        CustomMemberDetails customMemberDetails = new CustomMemberDetails();

        return customMemberDetails;
    }
}
