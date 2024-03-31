package org.example.todolist.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter @Setter @ToString
@AllArgsConstructor @NoArgsConstructor
@Builder
@Table(name = "todo")
@EntityListeners(value = {AuditingEntityListener.class})
@Entity
public class TodolistEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;        // 번호

    @Column(length = 50, nullable = false)
    private String title;   // 제목

    @Column(nullable = false)
    private String content; // 내용

    @Column(length = 10, nullable = false)
    private String level;      // 중요도

    @LastModifiedDate
    private LocalDateTime modDate;  // 수정일

}
