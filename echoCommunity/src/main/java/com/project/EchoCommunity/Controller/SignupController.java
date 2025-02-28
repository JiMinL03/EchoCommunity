package com.project.EchoCommunity.Controller;

import com.project.EchoCommunity.Service.DeptService;
import org.springframework.ui.Model;
import com.project.EchoCommunity.Form.RegisterForm;
import com.project.EchoCommunity.Service.UserService;
import jakarta.validation.Valid;
import com.project.EchoCommunity.Entity.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class SignupController { //회원가입 컨트롤러
    private final UserService userService;
    private final DeptService deptService;

    @GetMapping("signup")
    public String signupPage() {
        return "term";
    }

    @GetMapping("register")
    public String registerForm(Model model) {
        model.addAttribute("registerForm", new RegisterForm());
        model.addAttribute("departments", deptService.getDeptRepository().findAll());
        return "register";
    }

    @PostMapping("register")
    public String register(@Valid RegisterForm form, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return "register";
        }

        if (userService.existsById(form.getId())) { //이미 사용중인 아이디라면
            bindingResult.rejectValue("id", "duplicate", "이미 사용 중인 아이디입니다.");
            return "redirect:/register"; //다시 register 페이지 새로고침
        }

        if(!form.getPassword().equals(form.getPassword2())){
            bindingResult.rejectValue("password2", "passwordInCorrect", "2개의 비밀번호가 일치하지 않습니다.");
            return "redirect:/register";
        }

        Users newUser = userService.create(form.getId(), form.getPassword(), form.getUsername(),form.getNickname(),
                form.getJob(),form.getAge(), form.getBirthday(), 0, form.getDept(), null);

        System.out.println("새로운 회원 생성됨: " + newUser.getNickname());
        return "redirect:/home";
    }
}
