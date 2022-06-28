package com.example.demo.controllers;

import com.example.demo.entities.Absence;
import com.example.demo.exceptions.Exceptions;
import com.example.demo.services.AbsenceImpl;
import com.example.demo.services.CoursImpl;
import com.example.demo.services.EtudiantImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AbsenceController {

    @Autowired
    private CoursImpl coursImpl;
    @Autowired
    private EtudiantImpl etudiantImpl;

    @Autowired
    private AbsenceImpl absenceImpl;

    @GetMapping("/absence")
    public String showAbsence(Model model){
        model.addAttribute("listabsence",absenceImpl.getAbsence());

        return  "admin/table-absence";
    }

    @PostMapping("/saveAbsence")
    public String saveAbsence(@ModelAttribute("absence") Absence absence) throws Exceptions {
        absenceImpl.addNewAbsence(absence);
        return "redirect:/absence";
    }


    @GetMapping("/showNewAbsenceForm")
    public String showNewAbsenceForm(Model model) throws Exceptions {
        //create model attribute to bind form data
        Absence absence = new Absence();
        model.addAttribute("absence", absence);
        model.addAttribute("listcours",coursImpl.getCours());
        model.addAttribute("listetudiant",etudiantImpl.getEtudiant());
        return "admin/new-absence";
    }
    @GetMapping("/showFormUpdateAbsence/{id}")
    public String showFormUpdateAbsence(@PathVariable(value="id") long id, Model model) throws Exceptions {
        // Get examens from the service
        Absence absence=absenceImpl.getById(id);

        //set examens as a model attribute to pre-populate the form
        model.addAttribute("absence", absence);
        model.addAttribute("listcours",coursImpl.getCours());
        model.addAttribute("listetudiant",etudiantImpl.getEtudiant());
        return "admin/update_absence";

    }
    @GetMapping("/deleteAbsence/{id}")
    public String deleteAbsence(@PathVariable (value = "id") long id) throws Exceptions {
        // call elete examens method
        this.absenceImpl.deleteAbsence(id);
        return "redirect:/absence";
    }
    @PostMapping("/updateAbsence")
    public String updateAbsence(@ModelAttribute("absence") Absence absence) throws Exceptions {
        absenceImpl.updateAbsence(absence.getId(),absence);
        return "redirect:/absence";
    }
}
