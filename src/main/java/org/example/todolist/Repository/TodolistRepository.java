package org.example.todolist.Repository;

import org.example.todolist.Entity.TodolistEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodolistRepository extends JpaRepository<TodolistEntity, Long> {

}
