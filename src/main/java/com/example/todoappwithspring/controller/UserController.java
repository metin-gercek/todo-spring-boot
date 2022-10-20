package com.example.todoappwithspring.controller;

import java.util.NoSuchElementException;

import org.springframework.web.bind.annotation.*;

import com.example.todoappwithspring.entity.Todo;
import com.example.todoappwithspring.entity.User;
import com.example.todoappwithspring.repository.TodoRepository;
import com.example.todoappwithspring.repository.UserRepository;

@RestController
@RequestMapping("/api/v1")
public class UserController {

	private UserRepository userRepository;
	private TodoRepository todoRepository;

	public UserController(UserRepository userRepository, TodoRepository todoRepository) {
		this.userRepository = userRepository;
		this.todoRepository = todoRepository;
	}

	@GetMapping("/{userId}")
	public User getUserById(@PathVariable Long userId) {
		return userRepository.findById(userId).orElseThrow(() -> new NoSuchElementException());
	}

	@PostMapping
	public User addUser(@RequestBody User user) {

		return userRepository.save(user);
	}

	@PostMapping("/{userId}/todos")
	public void addTodo(@PathVariable Long userId, @RequestBody Todo todo) {
		User user = userRepository.findById(userId).orElseThrow(() -> new NoSuchElementException());
		user.getTodoList().add(todo);
		userRepository.save(user);
	}

	@PostMapping("/todos/{todoId}")
	public void toggleTodoCompleted(@PathVariable Long todoId) {
		Todo todo = todoRepository.findById(todoId).orElseThrow(() -> new NoSuchElementException());
		todo.setCompleted(!todo.getCompleted());
		todoRepository.save(todo);
	}

	@DeleteMapping("{userId}/todos/{todoId}")
	public void deleteTodo(@PathVariable Long userId, @PathVariable Long todoId) {
		User user = userRepository.findById(userId).orElseThrow(() -> new NoSuchElementException());
		Todo todo = todoRepository.findById(todoId).orElseThrow(() -> new NoSuchElementException());
		user.getTodoList().remove(todo);
		todoRepository.delete(todo);
	}

	@DeleteMapping("/{userId}")
	public void deleteUser(@PathVariable Long userId) {
		User user = userRepository.findById(userId).orElseThrow(() -> new NoSuchElementException());
		userRepository.delete(user);
	}
}
