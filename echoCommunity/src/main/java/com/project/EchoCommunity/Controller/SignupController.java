package com.project.EchoCommunity.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SignupController { //회원가입 컨트롤러
    @GetMapping("register")
    public String register() {
        return "register";
    }
}
