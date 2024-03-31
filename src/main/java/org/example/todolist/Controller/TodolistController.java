package org.example.todolist.Controller;

import lombok.RequiredArgsConstructor;
import org.example.todolist.DTO.TodolistDTO;
import org.example.todolist.Entity.TodolistEntity;
import org.example.todolist.Repository.TodolistRepository;
import org.example.todolist.Service.TodolistService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class TodolistController {
    private final TodolistService todolistService;
    private final ModelMapper modelMapper;


    // list
    @GetMapping("/")
    public String index(@PageableDefault(page = 1)Pageable pageable, Model model) {
        Page<TodolistDTO> todolistDTOS = todolistService.list(pageable);
        model.addAttribute("todolistDTOS", todolistDTOS);
        return "index";
    }


    // insert
    @GetMapping("/insert")
    public String insertForm() {
        return "insert";
    }
    @PostMapping("/insert")
    public String insertProc(TodolistDTO todolistDTO) {
        todolistService.insert(todolistDTO);
        return "redirect:/";
    }


    // delete
    @GetMapping("/delete/{id}")
    public String deleteProc(@PathVariable Long id) {
        todolistService.delete(id);
        return "redirect:/";
    }

}
