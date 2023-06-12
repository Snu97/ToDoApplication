package com.codestates.todoApp.todo.repository;

import com.codestates.todoApp.todo.entitiy.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {

}
