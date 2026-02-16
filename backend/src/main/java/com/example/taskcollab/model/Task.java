package com.example.taskcollab.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String title;
    
    private String description;
    
    @Column(name = "list_id")
    private Long listId;
    
    @Column(nullable = false)
    private Integer position;
    
    @Column(name = "assigned_to")
    private Long assignedTo;
    
    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();
    
    @Column(name = "updated_at")
    private LocalDateTime updatedAt = LocalDateTime.now();
    
    // Default constructor
    public Task() {}
    
    public Task(String title, Long listId, Integer position, Long assignedTo) {
        this.title = title;
        this.listId = listId;
        this.position = position;
        this.assignedTo = assignedTo;
    }
    
    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public Long getListId() { return listId; }
    public void setListId(Long listId) { this.listId = listId; }
    public Integer getPosition() { return position; }
    public void setPosition(Integer position) { this.position = position; }
    public Long getAssignedTo() { return assignedTo; }
    public void setAssignedTo(Long assignedTo) { this.assignedTo = assignedTo; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}

