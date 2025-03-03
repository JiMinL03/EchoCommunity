package com.project.EchoCommunity.Controller;

import com.project.EchoCommunity.Entity.Question;
import com.project.EchoCommunity.Entity.Users;
import com.project.EchoCommunity.Service.AnswerService;
import com.project.EchoCommunity.Service.QuestionService;
import com.project.EchoCommunity.Service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class AnswerController {
    private final AnswerService answerService;
    private final QuestionService questionService;
    private final UserService userService;

    @PostMapping("/answer/create/{id}")
    public String createAnswer(@PathVariable int id, Model model, @RequestParam(value="content") String content, HttpSession session) {
        Question question = this.questionService.getQuestion(id);
        Users user = this.userService.getUser((String)session.getAttribute("userId"));
        //답변 저장
        answerService.saveAnswer(question, content,user.getId()); //답변 작성자 id
        return String.format("redirect:/question/detail/%s", id);
    }
}
