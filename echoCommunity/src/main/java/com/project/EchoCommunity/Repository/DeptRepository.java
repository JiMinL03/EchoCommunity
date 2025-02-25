package com.project.EchoCommunity.Repository;

import com.project.EchoCommunity.Entity.Dept;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeptRepository extends JpaRepository<Dept, Integer> {
}
