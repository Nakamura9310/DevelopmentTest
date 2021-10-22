package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;


@Data
@Controller
@RequiredArgsConstructor
public class TaskController {

    @GetMapping(value = "/top")
    public String displayTop(Model model) {
        
        return "/top.html";
    }
    
    
}
