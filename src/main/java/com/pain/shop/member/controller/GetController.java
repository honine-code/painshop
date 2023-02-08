package com.pain.shop.member.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetController {

    @RequestMapping("/list")
    public String getList() {
        return "Hello";
    }
}
