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

    @Size(min = 5, max = 10)
    private String username;

    @Size(min = 5, max = 20)
    private String nickname;

    @NotEmpty(message = "직업은 필수 항목입니다.")
    private String job;

    @Min(value = 1, message = "나이는 1 이상이어야 합니다.")  // ✅ 숫자 검증 방식으로 변경
    private int age;

    @NotNull(message = "생년월일은 필수 항목입니다.")  // ✅ @NotNull 사용
    private LocalDate birthday;

    @NotNull(message = "전공은 필수 항목입니다.")  // ✅ @NotNull 사용
    private String dept;

    private int point;

    private byte[] img;
}
