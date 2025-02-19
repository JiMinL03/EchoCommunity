package com.project.EchoCommunity.Controller;

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
    public String homePage() {
        return "home";
    }
    @GetMapping("login")
    public String loginPage() {
        return "login";
    }
    @GetMapping("signup")
    public String signupPage() {
        return "term";
    }
    @GetMapping("qa") //qa.html 제작필요
    public String qaPage() {
        return "qa";
    }
    @GetMapping("contest") //contest.html 제작필요
    public String contestPage() {
        return "contest";
    }
    @GetMapping("certificate") //certificate.html 제작필요
    public String certificatePage() {
        return "certificate";
    }
    @GetMapping("counseling")
    public String counselingPage() {
        return "counsel";
    }
}
