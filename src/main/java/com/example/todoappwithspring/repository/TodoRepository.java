package com.example.todoappwithspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.todoappwithspring.entity.Todo;

public interface TodoRepository extends JpaRepository<Todo,Long> {
}
