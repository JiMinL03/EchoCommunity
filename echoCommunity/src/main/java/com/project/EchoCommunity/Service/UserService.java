package com.project.EchoCommunity.Service;

import com.project.EchoCommunity.Entity.Dept;
import com.project.EchoCommunity.Entity.Users;
import com.project.EchoCommunity.Repository.DeptRepository;
import com.project.EchoCommunity.Repository.UserRepository;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.time.LocalDate;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final DeptRepository deptRepository;

    public Users create(String id, String password, String username, String nickname, String job,
                        int age, LocalDate birthday, int point, String deptName, byte[] img){
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
        user.setImg(img);

        Dept dept = deptRepository.findById(deptName)
                .orElseThrow(() -> new IllegalArgumentException("해당 전공을 찾을 수 없습니다: " + deptName));
        user.setDept(dept);

        this.userRepository.save(user);
        return user;
    }

    public boolean existsById(String id) {
        return userRepository.existsById(id);
    }

    public boolean findByPassword(String password, String id) {
        Users user = userRepository.findById(id)
                .orElse(null);

        if (user == null) {
            return false;
        }
        return user.getPassword().equals(password);
    }

    public Users getUser(String id){
        System.out.println("user id: "+ id);
        Optional<Users> user = this.userRepository.findById(id);
        if(user.isPresent()){
            return user.get();
        }else{
            throw new NullPointerException("User not found");
        }
    }
}
