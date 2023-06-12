package com.codestates.todoApp.todo.service;

import com.codestates.todoApp.todo.entitiy.Todo;
import com.codestates.todoApp.todo.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService extends Exception{
    private final TodoRepository repository;

    public TodoService(TodoRepository repository) {
        this.repository = repository;
    }

    public Todo createTodo(Todo todo){
        Todo response = repository.save(todo);

        return response;
    }

    public Todo updateTodo(Todo todo){
        long todoId = todo.getId();
        Optional<Todo> findTodo = repository.findById(todoId);

        Todo response = findTodo.orElseThrow();

        Optional.ofNullable(todo.getTitle())
                .ifPresent(title -> response.setTitle(title));
        Optional.ofNullable(todo.getTodoOrder())
                .ifPresent(order -> response.setTodoOrder(order));
        Optional.ofNullable(todo.getCompleted())
                .ifPresent(completed -> response.setCompleted(completed));

        return response;
    }

    public Todo findTodo(long todoId){
        Optional<Todo> findTodo = repository.findById(todoId);

        Todo response = findTodo.orElseThrow();

        return response;
    }

    public List<Todo> findTodos(){
        List<Todo> response = repository.findAll();

        return response;
    }

    public void deleteTodo(long todoId){

        Optional<Todo> findTodo = repository.findById(todoId);
        Todo response = findTodo.orElseThrow();

        repository.delete(response);
    }
}
