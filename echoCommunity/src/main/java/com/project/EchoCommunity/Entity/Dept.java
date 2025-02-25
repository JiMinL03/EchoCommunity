package com.project.EchoCommunity.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Dept {
    @Id
    private String dept; // 전공
    private String field;  // 전공 분야

    public Dept(String dept, String field) {
        //INSERT INTO dept (dept, field) VALUES ('공학', '전자공학');
        this.dept = dept;
        this.field = field;
    }
}
