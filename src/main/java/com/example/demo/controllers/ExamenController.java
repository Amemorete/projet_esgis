package com.example.demo.controllers;


import com.example.demo.entities.Examen;
import com.example.demo.exceptions.Exceptions;
import com.example.demo.services.CoursImpl;
import com.example.demo.services.EnseignantImpl;
import com.example.demo.services.EtudiantImpl;
import com.example.demo.services.ExamenImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ExamenController {
    @Autowired
    private CoursImpl coursImpl;
    @Autowired
    private EtudiantImpl etudiantImpl;

    @Autowired
    private EnseignantImpl enseignantImpl;

    @Autowired
    private ExamenImpl examenImpl;

    @GetMapping("/examen")
    public String showExamen(Model model){
        model.addAttribute("listexamen",examenImpl.getExamen());

        return  "admin/table-examen";
    }

    @PostMapping("/saveExamen")
    public String saveExamens(@ModelAttribute("cours") Examen examen) throws Exceptions {
        examenImpl.addNewExamen(examen);
        return "redirect:/examen";
    }


    @GetMapping("/showNewExamenForm")
    public String showNewExamensForm(Model model) throws Exceptions {
        //create model attribute to bind form data
        Examen examen = new Examen();
        model.addAttribute("examen", examen);
        model.addAttribute("listcours",coursImpl.getCours());
        model.addAttribute("listenseignant",enseignantImpl.getEnseingnant());
        model.addAttribute("listetudiant",etudiantImpl.getEtudiant());
        return "admin/new-examen";
    }
    @GetMapping("/showFormUpdateExamen/{id}")
    public String showFormUpdateExamens(@PathVariable(value="id") long id, Model model) throws Exceptions {
        // Get examens from the service
        Examen examen=examenImpl.getById(id);

        //set examens as a model attribute to pre-populate the form
        model.addAttribute("examen", examen);
        model.addAttribute("listcours",coursImpl.getCours());
        model.addAttribute("listenseignant",enseignantImpl.getEnseingnant());
        model.addAttribute("listetudiant",etudiantImpl.getEtudiant());
        return "admin/update_examen";

    }
    @GetMapping("/deleteExamen/{id}")
    public String deleteExamens(@PathVariable (value = "id") long id) throws Exceptions {
        // call elete examens method
        this.examenImpl.deleteExamen(id);
        return "redirect:/examen";
    }
    @PostMapping("/updateExamen")
    public String updateExamens(@ModelAttribute("examen") Examen examen) throws Exceptions {
        examenImpl.updateExamen(examen.getId(),examen);
        return "redirect:/examen";
    }



}
