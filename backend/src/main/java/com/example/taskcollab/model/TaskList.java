package com.example.taskcollab.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "lists")
public class TaskList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String name;
    
    @Column(name = "board_id")
    private Long boardId;
    
    @Column(nullable = false)
    private Integer position;
    
    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();
    
    // Default constructor
    public TaskList() {}
    
    public TaskList(String name, Long boardId, Integer position) {
        this.name = name;
        this.boardId = boardId;
        this.position = position;
    }
    
    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Long getBoardId() { return boardId; }
    public void setBoardId(Long boardId) { this.boardId = boardId; }
    public Integer getPosition() { return position; }
    public void setPosition(Integer position) { this.position = position; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}

