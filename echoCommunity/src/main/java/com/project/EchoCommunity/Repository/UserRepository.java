package com.project.EchoCommunity.Repository;

import com.project.EchoCommunity.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, String> {
}
