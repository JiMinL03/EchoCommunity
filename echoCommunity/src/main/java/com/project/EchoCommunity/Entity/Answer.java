package com.project.EchoCommunity.Entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(columnDefinition = "TEXT")
    private String content;

    @Column(length = 20) // nickname 길이를 적절히 제한, 한글로 최대 10글자
    private String nickname;

    private LocalDate createDate;

    @ManyToOne
    //답변 여러 개, 질문 게시글은 하나
    private Question question;

    private String authorId;
}
