package com.example.demo.services;


import com.example.demo.entities.Cours;
import com.example.demo.exceptions.Exceptions;
import com.example.demo.repositories.CoursRepo;
import com.example.demo.serviceinterface.CoursInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


/**
 * @author Amemorte //KOISONN MANES MANA
 * @since 28/05/2022
 * @version 1
 */

@Service
@Transactional
public class CoursImpl implements CoursInterface {
    @Autowired
    private CoursRepo coursRepo;


    @Override
    public List<Cours> getCours() {
        return coursRepo.findAll();
    }

    @Override
    public void addNewCours(Cours cours) throws Exceptions {
        coursRepo.save(cours);
    }

    @Override
    public void deleteCours(Long coursId) throws Exceptions {
        boolean exists = coursRepo.existsById(coursId);
        if(!exists)
            throw  new Exceptions(Exceptions.alertGeneralException("agr dont l id "+coursId+"n'existe pas "));

        coursRepo.deleteById(coursId);

    }

    @Override
    public void updateCours(Long id, Cours cours) throws Exceptions {
        if(!isPresent(cours.getId()))
            throw new Exceptions(Exceptions.alertGeneralException("l'identifiant n'esiste pas"));
        Cours cours1=getById(cours.getId());

        cours1.setCode(cours.getCode());
        cours1.setCredit(cours.getCredit());
        cours1.setLibelle(cours.getLibelle());

        cours1=coursRepo.save(cours1);

        if (cours1==null){
            throw new Exceptions(Exceptions.alertGeneralException("echoué"));
        }

    }

    @Override
    public Cours getById(Long id) throws Exceptions {
        if(!isPresent(id))
            throw new Exceptions(Exceptions.alertGeneralException("l'identifiant n'existe pas"));
        Optional<Cours> opad=coursRepo.findById(id);
        return  opad.get();
    }

    public boolean isPresent(String libelle){
        Optional<Cours> opab=coursRepo.findAgrByLibelle(libelle);
        if (opab.isPresent())
            return true;
        return false;
    }
    public boolean isPresent(Long id){
        Optional<Cours> opab=coursRepo.findById(id);
        if (opab.isPresent())
            return true;
        return false;
    }
}
