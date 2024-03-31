package org.example.todolist.DTO;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.time.LocalDateTime;

@Getter @Setter @ToString
@AllArgsConstructor @NoArgsConstructor
@Builder
public class TodolistDTO {

    private Long id;        // 번호

    @NotEmpty(message = "!")
    private String title;   // 제목

    @NotEmpty(message = "!")
    private String content; // 내용

    private String level;      // 중요도

    private LocalDateTime modDate;  // 수정일

}
