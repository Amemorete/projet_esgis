package com.example.demo.serviceinterface;




import com.example.demo.entities.Examen;
import com.example.demo.exceptions.Exceptions;

import java.util.List;

/**
 * @author Amemorte //KOISONN MANES MANA
 * @since 28/05/2022
 * @version 1
 */

public interface ExamenInterface {

    /**
     * Liste des examen
     * @return
     */
    List<Examen> getExamen();

    /**
     * creation d'un Examen
     * @param examen
     */
    public void addNewExamen(Examen examen) throws Exceptions;

    /**
     * supprimer un examen
     * @param examenId
     */
    void deleteExamen(Long examenId) throws Exceptions;

    public void updateExamen(Long id, Examen examen)throws Exceptions;

    public Examen getById(Long id) throws  Exceptions;

}
