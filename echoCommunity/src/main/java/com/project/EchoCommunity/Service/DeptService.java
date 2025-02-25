package com.project.EchoCommunity.Service;

import com.project.EchoCommunity.Entity.Dept;
import com.project.EchoCommunity.Repository.DeptRepository;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@Getter
@RequiredArgsConstructor
public class DeptService {
    @Autowired
    private final DeptRepository deptRepository;

    @PostConstruct
    public void initData() {
        List<Dept> depts = Arrays.asList(
                new Dept("전자공학", "공학"),
                new Dept("기계공학", "공학"),
                new Dept("컴퓨터공학", "공학"),
                new Dept("물리학", "자연과학"),
                new Dept("화학", "자연과학"),
                new Dept("생물학", "자연과학")
        );

        deptRepository.saveAll(depts); // 한 번에 저장
    }
}
