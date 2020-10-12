package com.alejandro.zemsaniaTest.repository;

import com.alejandro.zemsaniaTest.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

    User findByUsername(String username);
}
