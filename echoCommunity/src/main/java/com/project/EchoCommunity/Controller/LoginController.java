package com.project.EchoCommunity.Controller;

import com.project.EchoCommunity.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
@Controller
public class LoginController {
    private final UserService userService;

    @PostMapping("login")
    public String login(@RequestParam("id") String id,
                        @RequestParam("password") String password) {
        if(!userService.existsById(id) || !userService.findByPassword(password, id)){
            return "redirect:/login";
        }
        return "redirect:/home";
    }
}
