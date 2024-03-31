package org.example.todolist.Service;

import lombok.RequiredArgsConstructor;
import org.example.todolist.DTO.TodolistDTO;
import org.example.todolist.Entity.TodolistEntity;
import org.example.todolist.Repository.TodolistRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
@Transactional
@Service
public class TodolistService {
    private final TodolistRepository todolistRepository;
    private final ModelMapper modelMapper;

    // 삽입
    public void insert(TodolistDTO todolistDTO) {
        TodolistEntity todolistEntity = modelMapper.map(todolistDTO, TodolistEntity.class);
        todolistRepository.save(todolistEntity);
    }


    // 삭제
    public void delete(Long id) {
        todolistRepository.deleteById(id);
    }


    // 목록
    public Page<TodolistDTO> list(Pageable pageable) {
        int curPage = pageable.getPageNumber()-1;
        int pageCnt = 5;
        Pageable page = PageRequest.of(curPage, pageCnt, Sort.by(Sort.Direction.DESC, "id"));

        Page<TodolistEntity> todolistEntities = todolistRepository.findAll(page);

        Page<TodolistDTO> todolistDTOS = todolistEntities.map(data -> modelMapper.map(data, TodolistDTO.class));
        
        return todolistDTOS;
    }


}
