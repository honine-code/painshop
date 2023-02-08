package com.pain.shop.member.service.impl;

import com.pain.shop.member.dto.MemberDto;
import com.pain.shop.member.repository.MemberRepository;
import com.pain.shop.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    private final PasswordEncoder passwordEncoder;

    /**
     * 회원 가입
     */
    @Override
    public Long join(MemberDto memberDto) {
        validateDuplicateMember(memberDto);
        memberDto.setPassword(passwordEncoder.encode(memberDto.getPassword()));
        return memberRepository.save(memberDto.toEntity()).getId();
    }

    /**
     * 아이디 중복 검증
     */
    private void validateDuplicateMember(MemberDto memberDto) {
        List<MemberDto> findMembers = memberRepository.findByMemberId(memberDto.getMemberId());
        if (!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        } else {
            System.out.println("회원가입 완료");
        }
    }

    /**
     * 로그인
     */
    @Override
    public String login(String memberId, String password) {
        String getPassword = memberRepository.findByAll(memberId);

        if (passwordEncoder.matches(password, getPassword)) {
            return "login";
        }

        return "fail";
    }
}
