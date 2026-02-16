package com.example.taskcollab.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "activities")
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "task_id")
    private Long taskId;
    
    @Column(name = "user_id")
    private Long userId;
    
    @Column(nullable = false)
    private String action;
    
    private String details;
    
    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();
    
    // Default constructor
    public Activity() {}
    
    public Activity(Long taskId, Long userId, String action, String details) {
        this.taskId = taskId;
        this.userId = userId;
        this.action = action;
        this.details = details;
    }
    
    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getTaskId() { return taskId; }
    public void setTaskId(Long taskId) { this.taskId = taskId; }
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
    public String getAction() { return action; }
    public void setAction(String action) { this.action = action; }
    public String getDetails() { return details; }
    public void setDetails(String details) { this.details = details; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}

