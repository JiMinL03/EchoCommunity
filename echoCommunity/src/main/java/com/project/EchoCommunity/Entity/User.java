package com.project.EchoCommunity.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class User {
    @Id
    @Column(unique = true)  // 로그인 시 사용할 고유 ID, 즉 id를 유니크로 설정
    private String id;

    @Column(length = 20) //오직 영어로만 20글자
    private String password;

    @Column(length = 10) // username 길이를 적절히 제한, 한글로 최대 5글자
    private String username;

    @Column(length = 20) // nickname 길이를 적절히 제한, 한글로 최대 10글자
    private String nickname;

    private String job;
    private int age;
    private LocalDate birthday;
}
