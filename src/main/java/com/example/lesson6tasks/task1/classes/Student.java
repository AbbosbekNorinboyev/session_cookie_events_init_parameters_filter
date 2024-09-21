package com.example.lesson6tasks.task1.classes;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Student {
    private int id;
    private String full_name;
    private LocalDateTime created_at;
    private int age;
    private int group_id;
    private int created_by;
}
