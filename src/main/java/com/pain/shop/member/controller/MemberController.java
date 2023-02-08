package com.pain.shop.member.controller;

import com.pain.shop.member.dto.MemberDto;
import com.pain.shop.member.service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
//http://localhost/api/v1/member
public class MemberController {

    private final MemberService memberService;

    /**
     * 회원가입 화면
     */
    @GetMapping("/member/new")
    public String dspSinUp(Model model) {
        model.addAttribute("createForm", new MemberDto());
        return "member/createMember";
    }

    /**
     * 회원가입 실행
     */
    @PostMapping("/member/new")
    public String signUp(MemberDto memberDto) {
        memberService.join(memberDto);
        return "redirect:/";
    }

    /**
     * 로그인 화면
     */
    @GetMapping("/member/login")
    public String dspLogin(Model model) {
        model.addAttribute("loginForm", new MemberDto());

        return "member/loginMember";
    }

    /**
     * 로그인 실행
     */
    @PostMapping("/member/login")
    public String login(String memberId, String password) {
        memberService.login(memberId, password);

        return "redirect:/";
    }
}
