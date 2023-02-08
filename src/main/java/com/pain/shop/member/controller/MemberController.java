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
    public String dispSinUp(Model model) {
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

}
