package com.example.todoappwithspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.todoappwithspring.entity.Todo;
import com.example.todoappwithspring.entity.User;
import com.example.todoappwithspring.repository.UserRepository;



@SpringBootApplication
public class TodoAppWithSpringApplication implements CommandLineRunner  {

    @Autowired
    private UserRepository userRepository;
    @Autowired

    public static void main(String[] args) {
        SpringApplication.run(TodoAppWithSpringApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        User user = new User();
        user.setPassword("password");
        user.setUsername("John");

        Todo todo  = new Todo();
        todo.setContent("Upload video to YT");

        user.getTodoList().add(todo);

        userRepository.save(user);
    }
}
