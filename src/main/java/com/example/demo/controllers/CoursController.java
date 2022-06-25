package com.example.demo.controllers;

import com.example.demo.entities.Cours;
import com.example.demo.exceptions.Exceptions;
import com.example.demo.services.CoursImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CoursController {

    @Autowired
    private CoursImpl coursImpl;

    @GetMapping("/cours")
    public String showCours(Model model){
        model.addAttribute("listcours",coursImpl.getCours());

        return  "admin/table-cours";
    }

    @PostMapping("/saveCours")
    public String saveCours(@ModelAttribute("cours") Cours cours) throws Exceptions {
        coursImpl.addNewCours(cours);
        return "redirect:/cours";
    }


    @GetMapping("/NewCoursForm")
    public String showNewCoursForm(Model model) {
        //create model attribute to bind form data
        Cours cours = new Cours();
        model.addAttribute("cours", cours);
        return "admin/new-cours";
    }
    @GetMapping("/showFormUpdateCours/{id}")
    public String showFormUpdateCour(@PathVariable(value="id") long id, Model model) throws Exceptions {
        // Get cours from the service
        Cours cours=coursImpl.getById(id);

        //set employee as a model attribute to pre-populate the form
        model.addAttribute("cours", cours);
        return "admin/update_cours";

    }
    @GetMapping("/deleteCours/{id}")
    public String deleteCours(@PathVariable (value = "id") long id) throws Exceptions {
        // call elete cours method
        this.coursImpl.deleteCours(id);
        return "redirect:/cours";
    }
    @PostMapping("/updateCours")
    public String updateCours(@ModelAttribute("cours") Cours cours) throws Exceptions {
        coursImpl.updateCours(cours.getId(),cours);
        return "redirect:/cours";
    }
}
