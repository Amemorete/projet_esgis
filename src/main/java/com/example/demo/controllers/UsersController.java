package com.example.demo.controllers;

import com.example.demo.entities.Etudiant;
import com.example.demo.entities.Users;
import com.example.demo.exceptions.Exceptions;
import com.example.demo.serviceinterface.EtudiantInterface;;
import com.example.demo.services.UserImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UsersController {

    @Autowired
    private EtudiantInterface etudiantInterface;

    @Autowired
    private UserImpl userImpl;

    @GetMapping("/users")
    public String showUsers(Model model)throws Exceptions {
        List<Users>usersList=userImpl.getUsers();

        Users users = new Users();
        model.addAttribute("listetudiants", usersList);
        model.addAttribute("users", users);


        return  "admin/table-users";
    }
    @PostMapping("/saveUsers")
    public String saveUsers(@ModelAttribute("users") Users users) throws Exceptions {
        userImpl.addNewUser(users);
        return "redirect:/users";
    }


    @GetMapping("/showNewUsersForm")
    public String showNewUsersForm(Model model) {
        //create model attribute to bind form data
        Users users = new Users();
        model.addAttribute("users", users);
        return "admin/new-users";
    }
    @GetMapping("/showFormUpdateUsers/{id}")
    public String showFormUpdate(@PathVariable(value="id") long id, Model model) throws Exceptions {
        // Get employee from the service
        Users users=userImpl.getById(id);

        //set employee as a model attribute to pre-populate the form
        model.addAttribute("users", users);
        return "admin/update_users";

    }
    @GetMapping("/deleteUsers/{id}")
    public String deleteEmployee(@PathVariable (value = "id") long id) throws Exceptions {
        // call elete employee method
        this.userImpl.deleteUsers(id);
        return "redirect:/users";
    }
    @PostMapping("/updateUsers")
    public String updateEtudiant(@ModelAttribute("users") Users users) throws Exceptions {
        userImpl.updateUsers(users.getId(),users);
        return "redirect:/users";
    }


}
