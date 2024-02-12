package net.javaproject.todo.service.impl;

import lombok.AllArgsConstructor;
import net.javaproject.todo.dto.TodoDto;
import net.javaproject.todo.entity.Todo;
import net.javaproject.todo.repository.TodoRepository;
import net.javaproject.todo.service.TodoService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TodoServiceImpl implements TodoService {

    private TodoRepository todoRepository;
    private ModelMapper modelMapper;

    @Override
    public TodoDto addTodo(TodoDto todoDto) {

        // dto to jpa entity
        Todo todo = modelMapper.map(todoDto, Todo.class);

        /* adding jpa entity into repository */
        Todo savedTodo = todoRepository.save(todo);

        // jpa entity into dto
        return modelMapper.map(savedTodo, TodoDto.class);
    }
}