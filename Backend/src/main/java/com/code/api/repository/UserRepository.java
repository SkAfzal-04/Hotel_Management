package com.code.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.code.api.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
}
