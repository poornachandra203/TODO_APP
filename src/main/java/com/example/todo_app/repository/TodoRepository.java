package com.example.todo_app.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.todo_app.model.Todo;
@Repository
public interface TodoRepository extends JpaRepository<Todo,
Long> {
List<Todo> findByCompleted(boolean completed);
List<Todo> findByTitleContainingIgnoreCase(String title);
}