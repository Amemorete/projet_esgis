package com.example.demo.serviceinterface;


import com.example.demo.entities.Etudiant;
import com.example.demo.exceptions.Exceptions;

import java.util.List;

/**
 * @author Amemorte //KOISONN MANES MANA
 * @since 28/05/2022
 * @version 1
 */

public interface EtudiantInterface {
    /**
     * Liste des enseignant
     * @return
     */
    List<Etudiant> getEtudiant()throws Exceptions;

    /**
     * creation d'un Etudiant
     * @param etudiant
     */
    public void addNewEtudiant(Etudiant etudiant) throws Exceptions;

    /**
     * supprimer un enseignant
     * @param enseignantId
     */
    void deleteEtudiant(Long enseignantId) throws Exceptions;

    public void updateEtudiant(Long id, Etudiant etudiant)throws Exceptions;

    public Etudiant getById(Long id) throws  Exceptions;

}
