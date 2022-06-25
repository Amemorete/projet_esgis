package com.example.demo.serviceinterface;

import com.example.demo.entities.Users;
import com.example.demo.exceptions.Exceptions;

import java.util.List;

public interface UserInterface {

    /**
     * Liste des Users
     * @return
     */
    List<Users> getUsers()throws Exceptions;

    /**
     * creation d'un Users
     * @param users
     */
    public void addNewUser(Users users) throws Exceptions;

    /**
     * supprimer un enseignant
     * @param usersId
     */
    void deleteUsers(Long usersId) throws Exceptions;

    public void updateUsers(Long id, Users users)throws Exceptions;

    public Users getById(Long id) throws  Exceptions;

}
