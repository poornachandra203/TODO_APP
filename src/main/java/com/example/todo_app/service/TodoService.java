package com.example.todo_app.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.todo_app.model.Todo;
import com.example.todo_app.repository.TodoRepository;
@Service
public class TodoService {
@Autowired
private TodoRepository todoRepository;
public List<Todo> getAllTodos() {
return todoRepository.findAll();
}
public Optional<Todo> getTodoById(Long id) {
return todoRepository.findById(id);
}
public List<Todo> getTodosByCompletion(boolean completed) {
return todoRepository.findByCompleted(completed);
}
public Todo createTodo(Todo todo) {
return todoRepository.save(todo);
}
public Todo updateTodo(Long id, Todo todoDetails) {

Optional<Todo> optionalTodo =
todoRepository.findById(id);
if (optionalTodo.isPresent()) {
Todo todo = optionalTodo.get();
todo.setTitle(todoDetails.getTitle());
todo.setDescription(todoDetails.getDescription());
todo.setCompleted(todoDetails.isCompleted());
return todoRepository.save(todo);
}
return null;
}
public boolean deleteTodo(Long id) {
if (todoRepository.existsById(id)) {
todoRepository.deleteById(id);
return true;
}
return false;
}
}