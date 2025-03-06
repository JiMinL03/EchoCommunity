package com.project.EchoCommunity.Service;

import com.project.EchoCommunity.Entity.Question;
import com.project.EchoCommunity.Entity.Users;
import com.project.EchoCommunity.Repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QuestionService {
    @Autowired
    private final QuestionRepository questionRepository;
    public List<Question> getList(){
        return questionRepository.findAll();
    }

    public void create(String subject, String content, String authorId){
        Question question;
        question = new Question();
        question.setSubject(subject);
        question.setContent(content);
        question.setCreateDate(LocalDate.now());
        question.setAuthorId(authorId);
        this.questionRepository.save(question);
    }

    public Question getQuestion(Integer id){
        Optional<Question> question = questionRepository.findById(id);
        if(question.isPresent()){
            return question.get();
        }else {
            throw new NullPointerException("question not found");
        }
    }

    public void modifyQuestion(Question question ,String subject, String content){
        question.setSubject(subject);
        question.setContent(content);
        this.questionRepository.save(question);
    }
    public void deleteQuestion(Question question){
        questionRepository.delete(question);
    }
}
