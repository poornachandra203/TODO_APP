package com.example.todo_app.controller;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.todo_app.model.Todo;
import com.example.todo_app.service.TodoService;
@RestController
@RequestMapping("/api/todos")
@CrossOrigin(origins = "http://localhost:3000") // For frontenddevelopment
public class TodoController {
@Autowired
private TodoService todoService;
@GetMapping
public List<Todo> getAllTodos() {
return todoService.getAllTodos();
}
@GetMapping("/{id}")
public ResponseEntity<Todo> getTodoById(@PathVariable Long
id) {
Optional<Todo> todo = todoService.getTodoById(id);
return todo.map(ResponseEntity::ok)
.orElse(ResponseEntity.notFound().build());
}
@GetMapping("/completed/{completed}")
public List<Todo> getTodosByCompletion(@PathVariable boolean
completed) {
return todoService.getTodosByCompletion(completed);
}

@PostMapping
public Todo createTodo(@RequestBody Todo todo) {
return todoService.createTodo(todo);
}
@PutMapping("/{id}")
public ResponseEntity<Todo> updateTodo(@PathVariable Long
id, @RequestBody Todo todoDetails) {
Todo updatedTodo = todoService.updateTodo(id,
todoDetails);
if (updatedTodo != null) {
return ResponseEntity.ok(updatedTodo);
}
return ResponseEntity.notFound().build();
}
@DeleteMapping("/{id}")
public ResponseEntity<?> deleteTodo(@PathVariable Long id) {
boolean deleted = todoService.deleteTodo(id);
if (deleted) {
return ResponseEntity.ok().build();
}
return ResponseEntity.notFound().build();
}
}