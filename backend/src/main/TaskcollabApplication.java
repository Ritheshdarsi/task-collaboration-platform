package com.example.taskcollab;

import com.example.taskcollab.model.User;
import com.example.taskcollab.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class TaskcollabApplication {
    public static void main(String[] args) {
        SpringApplication.run(TaskcollabApplication.class, args);
    }
    
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    CommandLineRunner initData(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            if (userRepository.findByUsername("admin").isEmpty()) {
                User admin = new User("admin", "admin@example.com", 
                    passwordEncoder.encode("admin"));
                userRepository.save(admin);
                System.out.println("✅ Admin user created: admin/admin");
            }
        };
    }
}

