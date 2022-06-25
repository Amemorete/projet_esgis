package com.example.demo.serviceinterface;


import com.example.demo.entities.Cours;
import com.example.demo.exceptions.Exceptions;


import java.util.List;

/**
 * @author Amemorte //KOISONN MANES MANA
 * @since 28/05/2022
 * @version 1
 */

public interface CoursInterface {
    /**
     * Liste des cours
     * @return
     */
    List<Cours> getCours();

    /**
     * creation d'un cours
     * @param cours
     */
    public void addNewCours(Cours cours) throws Exceptions;

    /**
     * supprimer un cours
     * @param coursId
     */
    void deleteCours(Long coursId) throws Exceptions;

    public void updateCours(Long id, Cours cours)throws Exceptions;

    public Cours getById(Long id) throws  Exceptions;

}
