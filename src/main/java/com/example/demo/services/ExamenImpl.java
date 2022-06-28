package com.example.demo.services;


import com.example.demo.entities.Examen;
import com.example.demo.exceptions.Exceptions;
import com.example.demo.repositories.ExamenRepo;
import com.example.demo.serviceinterface.ExamenInterface;
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
public class ExamenImpl implements ExamenInterface {


    @Autowired
    private ExamenRepo examenRepo;
    @Override
    public List<Examen> getExamen() {
        return examenRepo.findAll();
    }

    @Override
    public void addNewExamen(Examen examen) throws Exceptions {

        Examen examen1=examenRepo.save(examen);

        if (examen1==null){
            throw  new Exceptions(Exceptions.alertGeneralException("entrer des données"));
        }

    }

    @Override
    public void deleteExamen(Long examenId) throws Exceptions {
        boolean exists = examenRepo.existsById(examenId);
        if(!exists)
            throw  new Exceptions(Exceptions.alertGeneralException("agr dont l id "+examenId+"n'existe pas "));

        examenRepo.deleteById(examenId);

    }

    @Override
    public void updateExamen(Long id, Examen examen) throws Exceptions {
        if(!isPresent(examen.getId()))
            throw new Exceptions(Exceptions.alertGeneralException("l'identifiant n'esiste pas"));
        Examen examen1=getById(examen.getId());
        examen1.setNote(examen.getNote());
        examen1.setEtudiant(examen.getEtudiant());
        examen1.setEnseignant(examen.getEnseignant());

        Examen examen2=examenRepo.save(examen1);

        if (examen2==null)
            throw  new Exceptions(Exceptions.alertGeneralException("rentrer les données"));

    }

    @Override
    public Examen getById(Long id) throws Exceptions {
        if(!isPresent(id))
            throw new Exceptions(Exceptions.alertGeneralException("l'identifiant n'existe pas"));
        Optional<Examen> opad=examenRepo.findById(id);
        return  opad.get();
    }


    public boolean isPresent(Long id){
        Optional<Examen> opab=examenRepo.findById(id);
        if (opab.isPresent())
            return true;
        return false;
    }
}
