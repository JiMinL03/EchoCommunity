package com.project.EchoCommunity.Controller;

import com.project.EchoCommunity.Service.DeptService;
import org.springframework.ui.Model;
import com.project.EchoCommunity.Form.RegisterForm;
import com.project.EchoCommunity.Service.UserService;
import jakarta.validation.Valid;
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

    @GetMapping("register")
    public String registerForm(Model model) {
        model.addAttribute("registerForm", new RegisterForm());
        model.addAttribute("departments", deptService.getDeptRepository().findAll());
        return "register";
    }

    @PostMapping("register")
    public String register(@Valid RegisterForm form, BindingResult bindingResult) {
        /*if (bindingResult.hasErrors()){
            return "register";
        }*/
        System.out.println("선택된 전공: " + form.getDept());

        if (userService.existsById(form.getId())) { //이미 사용중인 아이디라면
            bindingResult.rejectValue("id", "duplicate", "이미 사용 중인 아이디입니다.");
            return "register";
        }

        if(!form.getPassword().equals(form.getPassword2())){
            bindingResult.rejectValue("password2", "passwordInCorrect", "2개의 비밀번호가 일치하지 않습니다.");
            return "register";
        }

        userService.create(form.getId(), form.getPassword(), form.getUsername(),form.getNickname(),
                form.getJob(),form.getAge(), form.getBirthday(), 0, form.getDept(), null);
        return "redirect:/home";
    }
}
