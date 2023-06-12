package com.codestates.todoApp.todo.mapper;


import com.codestates.todoApp.todo.dto.TodoDto;
import com.codestates.todoApp.todo.entitiy.Todo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TodoMapper {
    TodoDto.Response todoToTodoResponse(Todo todo);

    Todo todoPostToTodo(TodoDto.Post post);

    Todo todoPatchToTodo(TodoDto.Patch patch);

}
