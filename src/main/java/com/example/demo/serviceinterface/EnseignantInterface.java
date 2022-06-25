package com.example.demo.serviceinterface;


import com.example.demo.entities.Enseignant;
import com.example.demo.exceptions.Exceptions;

import java.util.List;

/**
 * @author Amemorte //KOISONN MANES MANA
 * @since 28/05/2022
 * @version 1
 */

public interface EnseignantInterface {
    /**
     * Liste des enseignant
     * @return
     */
    List<Enseignant> getEnseingnant();

    /**
     * creation d'un enseignant
     * @param enseignant
     */
    public void addNewEnseignant(Enseignant enseignant) throws Exceptions;

    /**
     * supprimer un enseignant
     * @param enseignantId
     */
    void deleteEnseignant(Long enseignantId) throws Exceptions;

    public void updateEnseignant(Long id, Enseignant enseignant)throws Exceptions;

    public Enseignant getById(Long id) throws  Exceptions;

}
