package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/calandrier")
    public String showAbsence(Model model){


        return  "admin/uc-calendar";
    }
}
