package net.javaproject.todo.service.impl;

import lombok.AllArgsConstructor;
import net.javaproject.todo.dto.TodoDto;
import net.javaproject.todo.entity.Todo;
import net.javaproject.todo.exception.ResourceNotFoundException;
import net.javaproject.todo.repository.TodoRepository;
import net.javaproject.todo.service.TodoService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TodoServiceImpl implements TodoService {

    private TodoRepository todoRepository;
    private ModelMapper modelMapper;

    @Override
    public TodoDto addTodo(TodoDto todoDto) {

        // dto to jpa entity
        Todo todo = modelMapper.map(todoDto, Todo.class);

        Todo savedTodo = todoRepository.save(todo);

        // jpa entity into dto
        return modelMapper.map(savedTodo, TodoDto.class);
    }

    @Override
    public TodoDto getTodo(Long id) {

        Todo gotTodo = todoRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Todo with id, " + id + "is not found")
        );
        return modelMapper.map(gotTodo, TodoDto.class);
    }

    @Override
    public List<TodoDto> getAllTodos() {
        List<Todo> allTodos = todoRepository.findAll();
        return allTodos.stream().map(
                (todo) -> modelMapper.map(todo, TodoDto.class)).collect(Collectors.toList());
    }

    @Override
    public TodoDto updateTodo(TodoDto todoDto, Long id) {

        Todo todo = todoRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Todo with id, " + id + "is not found")
        );

        todo.setTitle(todoDto.getTitle());
        todo.setDescription(todoDto.getDescription());
        todo.setCompleted(todoDto.isCompleted());

        return modelMapper.map(todoRepository.save(todo), TodoDto.class);
    }

    @Override
    public void deleteTodo(Long id) {
        Todo todo = todoRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Todo with id, " + id + "is not found")
        );

        todoRepository.deleteById(id);
    }

    @Override
    public TodoDto completeTodo(Long id) {

        Todo todo = todoRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Todo with id, " + id + "is not found")
        );

        todo.setCompleted(true);

        return modelMapper.map(todoRepository.save(todo), TodoDto.class);
    }

    @Override
    public TodoDto inCompleteTodo(Long id) {

        Todo todo = todoRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Todo with id, " + id + "is not found")
        );

        todo.setCompleted(false);

        return modelMapper.map(todo, TodoDto.class);
    }
}