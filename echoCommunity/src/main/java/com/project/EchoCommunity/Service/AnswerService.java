package com.project.EchoCommunity.Service;

import com.project.EchoCommunity.Entity.Answer;
import com.project.EchoCommunity.Entity.Question;
import com.project.EchoCommunity.Repository.AnswerRepository;
import com.project.EchoCommunity.Repository.UserRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@Getter
@Setter
@RequiredArgsConstructor
public class AnswerService {
    @Autowired
    private final AnswerRepository answerRepository;
    private final UserRepository userRepository;

    public void saveAnswer(Question question, String content, String authorId) {
        Answer answer = new Answer();
        answer.setContent(content);
        answer.setCreateDate(LocalDate.now());
        answer.setQuestion(question);
        answer.setAuthorId(authorId);
        this.answerRepository.save(answer);
    }
}
