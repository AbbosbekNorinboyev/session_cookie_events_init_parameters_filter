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
public class Groups {
    private int id;
    private String group_name;
    private LocalDateTime created_at;
    private int count;
    private int created_by;
}
