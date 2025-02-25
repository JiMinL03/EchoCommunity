package com.project.EchoCommunity.Service;

import com.project.EchoCommunity.Entity.Dept;
import com.project.EchoCommunity.Entity.Users;
import com.project.EchoCommunity.Repository.UserRepository;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public Users create(String id, String password, String username, String nickname, String job,
                        int age, LocalDate birthday, int point, Dept dept, byte[] img){
        //User 회원 생성
        //스프링 시큐리티 기능 추가 필요함
        Users user = new Users();
        user.setId(id);
        user.setPassword(password);
        user.setUsername(username);
        user.setNickname(nickname);
        user.setJob(job);
        user.setAge(age);
        user.setBirthday(birthday);
        user.setPoint(point);
        user.setDept(dept);
        user.setImg(img);
        this.userRepository.save(user);
        return user;
    }

    public boolean existsById(String id) {
        return true;
    }
}
