package net.javaproject.todo.controller;

import net.javaproject.todo.dto.TodoDto;
import net.javaproject.todo.entity.Todo;
import net.javaproject.todo.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/todos")
public class TodoController {
    private TodoService todoService;

    // Build add todo REST API
    @PostMapping
    public ResponseEntity<TodoDto> addTodo(@RequestBody TodoDto todoDto){
        TodoDto addedTodo = todoService.addTodo(todoDto);
        return new ResponseEntity<>(addedTodo, HttpStatus.CREATED);
    }
}