package com.project.EchoCommunity.Controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController { //메인화면 페이지 이동
    @GetMapping("/")
    public String root(){
        return "redirect:/home";
    }

    @GetMapping("/home")
    public String home(HttpSession session) {
        String userId = (String) session.getAttribute("userId");  // 🔹 세션에서 userId 가져옴
        /*if (userId == null) {
            return "redirect:/login";
        }*/
        System.out.println("현재 로그인한 사용자 ID: " + userId);
        return "home";
    }
}
