package com.codestates.todoApp.todo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

public class TodoDto {

    @Getter
    @AllArgsConstructor
    public static class Post{

        @NotBlank
        private String title;
        @NotBlank
        private int todoOrder;
        @NotBlank
        private boolean completed;


    }


    @Getter
    @AllArgsConstructor
    public static class Patch{
        private Long id;
        private String title;
        private Integer todoOrder;
        private Boolean completed;

    }

    @Getter
    @Setter
    @AllArgsConstructor
    public static class Response{
        private Long id;
        private String title;
        private Integer todoOrder;
        private Boolean completed;


    }


}
