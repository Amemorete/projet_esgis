package com.example.demo.controllers;

import com.example.demo.entities.Enseignant;
import com.example.demo.exceptions.Exceptions;
import com.example.demo.services.EnseignantImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class EnseignantController {

    @Autowired
    EnseignantImpl enseignantImpl;

    @GetMapping("/enseignant")
    public String showEnseignant(Model model)throws Exceptions {
        List<Enseignant> enseignantList=enseignantImpl.getEnseingnant();
        model.addAttribute("listenseignant", enseignantList);


        return  "admin/table-enseignant.html";
    }
    @PostMapping("/saveEnseignant")
    public String saveEnseignant(@ModelAttribute("enseignant") Enseignant enseignant) throws Exceptions {
        enseignantImpl.addNewEnseignant(enseignant);
        return "redirect:/enseignant";
    }


    @GetMapping("/showNewEnseignantForm")
    public String showNewEtudiantForm(Model model) {
        //create model attribute to bind form data
        Enseignant enseignant = new Enseignant();
        model.addAttribute("enseignant", enseignant);
        return "admin/new-enseignant";
    }
    @GetMapping("/showFormUpdateEnseignant/{id}")
    public String showFormUpdate(@PathVariable(value="id") long id, Model model) throws Exceptions {
        // Get employee from the service
        Enseignant enseignant=enseignantImpl.getById(id);

        //set employee as a model attribute to pre-populate the form
        model.addAttribute("enseignant", enseignant);
        return "admin/update_enseignant";

    }
    @GetMapping("/deleteEnseignant/{id}")
    public String deleteEnseignant(@PathVariable (value = "id") long id) throws Exceptions {
        // call elete employee method
        this.enseignantImpl.deleteEnseignant(id);
        return "redirect:/enseignant";
    }
    @PostMapping("/updateEnseignant")
    public String updateEnseignant(@ModelAttribute("enseignant") Enseignant enseignant) throws Exceptions {
        enseignantImpl.updateEnseignant(enseignant.getId(),enseignant);
        return "redirect:/enseignant";
    }


}
