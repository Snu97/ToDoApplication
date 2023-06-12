package com.codestates.todoApp.todo.controller;

import com.codestates.todoApp.todo.dto.TodoDto;
import com.codestates.todoApp.todo.entitiy.Todo;
import com.codestates.todoApp.todo.mapper.TodoMapper;
import com.codestates.todoApp.todo.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/v1")
public class TodoController {
    private final TodoService todoService;
    private final TodoMapper mapper;

    public TodoController(TodoService todoService, TodoMapper mapper) {
        this.todoService = todoService;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity postTodo(@RequestBody TodoDto.Post post){
        Todo todo = mapper.todoPostToTodo(post);
        Todo response = todoService.createTodo(todo);

        return new ResponseEntity<>(mapper.todoToTodoResponse(response), HttpStatus.CREATED);
    }

    @PatchMapping("/{todo-id}")
    public ResponseEntity patchTodo(@PathVariable("todo-id") long todoId,
                                    @RequestBody TodoDto.Patch patch){
        Todo todo = mapper.todoPatchToTodo(patch);
        todo.setId(todoId);
        Todo response = todoService.updateTodo(todo);

        return new ResponseEntity<>(mapper.todoToTodoResponse(response), HttpStatus.OK);
    }

    @GetMapping("/{todo-id}")
    public ResponseEntity getTodo(@PathVariable("todo-id") long todoId){
        Todo response = todoService.findTodo(todoId);

        return new ResponseEntity<>(mapper.todoToTodoResponse(response), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getTodos(){
        List<Todo> response = todoService.findTodos();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{todo-id}")
    public ResponseEntity deleteTodo(@PathVariable("todo-id") long todoId){
        todoService.deleteTodo(todoId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
