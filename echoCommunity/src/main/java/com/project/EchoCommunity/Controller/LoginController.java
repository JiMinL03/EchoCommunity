package com.project.EchoCommunity.Controller;

import com.project.EchoCommunity.Service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
@Controller
public class LoginController {
    private final UserService userService;
    @GetMapping("login")
    public String loginPage() {
        return "login";
    }
    @PostMapping("login")
    public String login(@RequestParam("id") String id,
                        @RequestParam("password") String password, HttpSession session) {
        if(!userService.existsById(id) || !userService.findByPassword(password, id)){
            return "redirect:/login";
        }
        session.setAttribute("userId", id);
        return "redirect:/home";
    }

}
