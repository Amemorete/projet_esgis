package com.example.demo.controllers;

import com.example.demo.entities.Etudiant;
import com.example.demo.exceptions.Exceptions;
import com.example.demo.serviceinterface.EtudiantInterface;
import com.example.demo.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class EtudiantController {

    @Autowired
    private EtudiantImpl etudiantImpl;






    @GetMapping("")
    public String showPage(){
        return  "index";
    }

    @GetMapping("/admin")
    public String showAdmin(){
        return  "admin/index";
    }


    @GetMapping("/table2")
    public String showTable2(){
        return  "admin/table-export.html";
    }

    @GetMapping("/table3")
    public String showTable3(){
        return  "admin/table-export.html";
    }

    @GetMapping("/etudiant")
    public String showEtudiant(Model model)throws Exceptions {
        List<Etudiant> etudiantList=etudiantImpl.getEtudiant();
        model.addAttribute("listetudiants", etudiantList);


        return  "admin/table-etudiant.html";
    }
    @PostMapping("/saveEtudiant")
    public String saveEtudiant(@ModelAttribute("etudiant") Etudiant etudiant) throws Exceptions {
        etudiantImpl.addNewEtudiant(etudiant);
        return "redirect:/etudiant";
    }


    @GetMapping("/showNewEtudiantForm")
    public String showNewEtudiantForm(Model model) {
        //create model attribute to bind form data
        Etudiant etudiant = new Etudiant();
        model.addAttribute("etudiant", etudiant);
        return "admin/new-etudiant";
    }
    @GetMapping("/showFormUpdateEtudiant/{id}")
    public String showFormUpdate(@PathVariable(value="id") long id, Model model) throws Exceptions {
        // Get employee from the service
        Etudiant etudiant=etudiantImpl.getById(id);

        //set employee as a model attribute to pre-populate the form
        model.addAttribute("etudiant", etudiant);
        return "admin/update_etudiant";

    }
    @GetMapping("/deleteEtudiant/{id}")
    public String deleteEmployee(@PathVariable (value = "id") long id) throws Exceptions {
        // call elete employee method
        this.etudiantImpl.deleteEtudiant(id);
        return "redirect:/etudiant";
    }
    @PostMapping("/updateEtudiant")
    public String updateEtudiant(@ModelAttribute("etudiant") Etudiant etudiant) throws Exceptions {
        etudiantImpl.updateEtudiant(etudiant.getId(),etudiant);
        return "redirect:/etudiant";
    }







}
