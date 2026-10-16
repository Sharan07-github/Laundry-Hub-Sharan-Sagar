package com.servicehub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.servicehub.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

    boolean existsByEmail(String email);

    boolean existsByPhone(String phone);
}