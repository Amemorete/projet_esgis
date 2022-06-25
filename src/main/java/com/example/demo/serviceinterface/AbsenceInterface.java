package com.example.demo.serviceinterface;


import com.example.demo.entities.Absence;
import com.example.demo.exceptions.Exceptions;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.List;

/**
 * @author Amemorte //KOISONN MANES MANA
 * @since 28/05/2022
 * @version 1
 */
public interface AbsenceInterface {

    /**
     * Liste des absence
     * @return
     */
    List<Absence> getAbsence();

    /**
     * creation d'un absence
     * @param absence
     */
    public void addNewAbsence(Absence absence) throws Exceptions;

    /**
     * supprimer un agr
     * @param absenceId
     */
    void deleteAbsence(Long absenceId) throws Exceptions;

    public void updateAbsence(Long id, Absence absence)throws Exceptions;

    public Absence getById(Long id) throws  Exceptions;



}
