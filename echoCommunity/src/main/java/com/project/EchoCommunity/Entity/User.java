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
    private int point;

    @OneToOne(optional = false)
    @JoinColumn(name = "dept", referencedColumnName = "dept", nullable = false)
    //외래 키가 참조하는 대상 엔티티(여기서는 Dept)의 컬럼 이름을 지정, NULL 값을 허용하지 않음을 명시
    private Dept dept;

    @Lob
    @Column(name = "img")
    private byte[] img;

}
