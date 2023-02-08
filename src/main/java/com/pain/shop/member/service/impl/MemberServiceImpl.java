package com.pain.shop.member.service.impl;

import com.pain.shop.member.domain.Member;
import com.pain.shop.member.dto.MemberDto;
import com.pain.shop.member.repository.MemberRepository;
import com.pain.shop.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    public Long join(MemberDto memberDto) {

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        memberDto.setPassword(passwordEncoder.encode(memberDto.getPassword()));
        return memberRepository.save(memberDto.toEntity()).getId();
    }
}
