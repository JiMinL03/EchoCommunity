package com.project.EchoCommunity.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Dept {
    @Id
    private String dept; //전공
    private String group;  //전공 분야
}
