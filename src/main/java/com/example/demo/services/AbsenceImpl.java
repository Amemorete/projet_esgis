package com.example.demo.services;


import com.example.demo.entities.Absence;
import com.example.demo.exceptions.Exceptions;
import com.example.demo.repositories.AbsenceRepo;
import com.example.demo.serviceinterface.AbsenceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;


/**
 * @author Amemorte //KOISONN MANES MANA
 * @since 28/05/2022
 * @version 1
 */

@Service
@Transactional
public class AbsenceImpl implements AbsenceInterface {


    @Autowired
    private AbsenceRepo absenceRepo;


    @Override
    public List<Absence> getAbsence() {
        return absenceRepo.findAll();
    }

    @Override
    public void addNewAbsence(Absence absence) throws Exceptions {

        absence.setDate(new Date());

        absenceRepo.save(absence);

    }

    @Override
    public void deleteAbsence(Long absenceId) throws Exceptions {
        boolean exists = absenceRepo.existsById(absenceId);
        if(!exists)
            throw  new Exceptions(Exceptions.alertGeneralException("agr dont l id "+absenceId+"n'existe pas "));

        absenceRepo.deleteById(absenceId);

    }

    @Override
    public void updateAbsence(Long id, Absence absence) throws Exceptions {
        if(!isPresent(absence.getId()))
            throw new Exceptions(Exceptions.alertGeneralException("l'identifiant n'esiste pas"));
        Absence absence1=getById(absence.getId());

        absence1.setCours(absence.getCours());
        absence1.setDate(new Date());
        absence1.setEtudiant(absence1.getEtudiant());


        //update agr
        absence=absenceRepo.save(absence1);

        if (absence==null){
            throw new Exceptions(Exceptions.alertGeneralException("modification reussi"));
        }

    }

    @Override
    public Absence getById(Long id) throws Exceptions {
        if(!isPresent(id))
            throw new Exceptions(Exceptions.alertGeneralException("l'identifiant n'esiste pas"));
        Optional<Absence> opad=absenceRepo.findById(id);
        return  opad.get();
    }






    public boolean isPresent(Long id){
        Optional<Absence> opab=absenceRepo.findById(id);
        if (opab.isPresent())
            return true;
        return false;
    }
}
