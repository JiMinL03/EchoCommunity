package com.project.EchoCommunity.Form;

import com.project.EchoCommunity.Entity.Dept;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class RegisterForm {
    @NotEmpty(message = "사용자 ID는 필수 항목입니다.")
    @Size(min = 5)
    private String id;

    @NotEmpty(message = "비밀번호는 필수 항목입니다.")
    private String password;

    @NotEmpty(message = "비밀번호 확인은 필수 항목입니다.")
    private String password2;

    private String username;
    private String nickname;
    private String job;
    private int age;
    private LocalDate birthday;
    private String dept;
    private int point;
    private byte[] img;
}
