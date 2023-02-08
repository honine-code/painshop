package com.pain.shop.member.api;

import com.pain.shop.member.dto.MemberDto;
import com.pain.shop.member.service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/member")
//http://localhost/api/v1/member
public class MemberApiController {

    private final MemberService memberService;

    @GetMapping("/list")
    public String test() {
        return "Hello";
    }

    @PostMapping("/create")
    public Long signUp(@RequestBody MemberDto memberDto) {
        return memberService.join(memberDto);
    }

    @PostMapping("/test")
    public String postTest(@RequestBody MemberDto memberDto) {
        return memberDto.toString();
    }
}
