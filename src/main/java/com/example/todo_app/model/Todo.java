package com.example.todo_app.model;
import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
@Entity
@Table(name = "todos")
public class Todo {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
@Column(nullable = false)
private String title;
private String description;

private boolean completed = false;
@Column(name = "created_at")
private LocalDateTime createdAt;
@Column(name = "updated_at")
private LocalDateTime updatedAt;
// Pre-persist and pre-update methods
@PrePersist
protected void onCreate() {
createdAt = LocalDateTime.now();
updatedAt = LocalDateTime.now();
}
@PreUpdate
protected void onUpdate() {
updatedAt = LocalDateTime.now();
}
// Constructors
public Todo() {}
public Todo(String title, String description) {
this.title = title;
this.description = description;
}
// Getters and Setters
public Long getId() { return id; }
public void setId(Long id) { this.id = id; }
public String getTitle() { return title; }
public void setTitle(String title) { this.title = title; }
public String getDescription() { return description; }

public void setDescription(String description) {
this.description = description; }
public boolean isCompleted() { return completed; }
public void setCompleted(boolean completed) { this.completed
= completed; }
public LocalDateTime getCreatedAt() { return createdAt; }
public void setCreatedAt(LocalDateTime createdAt) {
this.createdAt = createdAt; }
public LocalDateTime getUpdatedAt() { return updatedAt; }
public void setUpdatedAt(LocalDateTime updatedAt) {
this.updatedAt = updatedAt; }
}