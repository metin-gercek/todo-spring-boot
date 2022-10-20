package com.example.todoappwithspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.todoappwithspring.entity.User;


public interface UserRepository extends JpaRepository<User,Long> {
}
