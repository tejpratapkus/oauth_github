package com.demo.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class UserController {

    @GetMapping("test")
    public String getMessage() {
        return "Welcome to oAuth Github Security";
    }

    /*
    @GetMapping
    public Map<String, Object> user(@AuthenticationPrincipal OAuth2User principal) {
        return Collections.singletonMap("name", principal.getAttribute("name"));
    }*/

    @GetMapping
    public Object sayHello(Authentication authentication) {
        return authentication.getPrincipal();
    }
}
