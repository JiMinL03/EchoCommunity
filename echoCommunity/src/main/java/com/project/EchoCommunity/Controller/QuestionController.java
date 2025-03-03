package com.project.EchoCommunity.Controller;

import com.project.EchoCommunity.Entity.Question;
import com.project.EchoCommunity.Entity.Users;
import com.project.EchoCommunity.Form.QuestionForm;
import com.project.EchoCommunity.Service.QuestionService;
import com.project.EchoCommunity.Service.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class QuestionController {
    private final QuestionService questionService;
    private final UserService userService;

    @GetMapping("/question/list") //qa.html 제작필요
    public String list(Model model) {
        List<Question> questionList = questionService.getList();
        model.addAttribute("questionList",questionList);
        return "question_list";
    }

    @GetMapping("/question/create")
    public String questionCreate() {
        return "question_form";
    }

    @PostMapping("/question/create")
    public String questionCreate(@Valid QuestionForm questionForm, BindingResult bindingResult, HttpSession session) {
        if(bindingResult.hasErrors()){
            return "question_form";
        }
        Users user = this.userService.getUser((String)session.getAttribute("userId"));
        this.questionService.create(questionForm.getSubject(), questionForm.getContent(), user.getId());
        return "redirect:/question/list";
    }

    @GetMapping("/question/detail/{id}")
    public String detail(@PathVariable int id, Model model) {
        Question question = this.questionService.getQuestion(id);
        model.addAttribute("question",question);
        return "question_detail";
    }
}
