package com.example.demo.services;


import com.example.demo.entities.Etudiant;
import com.example.demo.exceptions.Exceptions;
import com.example.demo.repositories.EtudiantRepo;
import com.example.demo.serviceinterface.EtudiantInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @author Amemorte //KOISONN MANES MANA
 * @since 28/05/2022
 * @version 1
 */

@Service
public class EtudiantImpl implements EtudiantInterface {


    @Autowired
    private EtudiantRepo etudiantRepo;


    @Override
    public List<Etudiant> getEtudiant()throws Exceptions {

        return etudiantRepo.findAll();
    }

    @Override
    public void addNewEtudiant(Etudiant etudiant) throws Exceptions {
        Etudiant etudiant1=etudiantRepo.save(etudiant);
        if (etudiant1==null)
            throw new Exceptions(Exceptions.alertGeneralException("entrer les données"));

    }

    @Override
    public void deleteEtudiant(Long etudiantId) throws Exceptions {
        boolean exists = etudiantRepo.existsById(etudiantId);
        if(!exists)
            throw  new Exceptions(Exceptions.alertGeneralException("agr dont l id "+etudiantId+"n'existe pas "));

        etudiantRepo.deleteById(etudiantId);


    }

    @Override
    public void updateEtudiant(Long id, Etudiant etudiant) throws Exceptions {
        if(!isPresent(etudiant.getId()))
            throw new Exceptions(Exceptions.alertGeneralException("l'identifiant n'esiste pas"));
        Etudiant etudiant1=getById(etudiant.getId());

        etudiant1.setNom(etudiant.getNom());
        etudiant1.setPrenom(etudiant.getPrenom());
        etudiant1.setSexe(etudiant.getSexe());
        etudiant1.setAdresse(etudiant.getAdresse());
        etudiant1.setEmail(etudiant.getEmail());
        etudiant1.setFiliere(etudiant.getFiliere());
        etudiant1.setDateNaissance(etudiant.getDateNaissance());
        etudiant1.setDateUpdate(new Date());

        Etudiant etudiant2=etudiantRepo.save(etudiant1);

        if (etudiant2==null){
            throw new Exceptions(Exceptions.alertGeneralException("echoué"));
        }


    }

    @Override
    public Etudiant getById(Long id) throws Exceptions {
        if(!isPresent(id))
            throw new Exceptions(Exceptions.alertGeneralException("l'identifiant n'existe pas"));
        Optional<Etudiant> opad=etudiantRepo.findById(id);
        return  opad.get();
    }


    public boolean isPresent(Long id){
        Optional<Etudiant> opab=etudiantRepo.findById(id);
        if (opab.isPresent())
            return true;
        return false;
    }
}
