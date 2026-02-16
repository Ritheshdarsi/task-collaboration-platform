package com.example.taskcollab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class TaskcollabApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(TaskcollabApplication.class, args);
    }
    
    @GetMapping("/api/health")
    public String health() {
        return "✅ Backend Working! Interview project LIVE";
    }
    
    @GetMapping("/api/boards")
    public String boards() {
        return "[{\"id\":1,\"name\":\"Demo Board\"}]";
    }
}

