package com.example.demo.services;



import com.example.demo.entities.Enseignant;
import com.example.demo.exceptions.Exceptions;
import com.example.demo.repositories.EnseignantRepo;
import com.example.demo.serviceinterface.EnseignantInterface;
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
public class EnseignantImpl implements EnseignantInterface {

    @Autowired
    private EnseignantRepo enseignantRepo;

    @Override
    public List<Enseignant> getEnseingnant() {
        return enseignantRepo.findAll();
    }

    @Override
    public void addNewEnseignant(Enseignant enseignant) throws Exceptions {

        Enseignant enseignant2=enseignantRepo.save(enseignant);
        if (enseignant2==null){
            throw new Exceptions(Exceptions.alertGeneralException("echoué"));
        }

    }

    @Override
    public void deleteEnseignant(Long enseignantId) throws Exceptions {
        boolean exists = enseignantRepo.existsById(enseignantId);
        if(!exists)
            throw  new Exceptions(Exceptions.alertGeneralException("agr dont l id "+enseignantId+"n'existe pas "));

        enseignantRepo.deleteById(enseignantId);

    }

    @Override
    public void updateEnseignant(Long id, Enseignant enseignant) throws Exceptions {
        if(!isPresent(enseignant.getId()))
            throw new Exceptions(Exceptions.alertGeneralException("l'identifiant n'esiste pas"));
        Enseignant enseignant1=getById(enseignant.getId());

        enseignant1.setNom(enseignant.getNom());
        enseignant1.setPrenom(enseignant.getPrenom());
        enseignant1.setSexe(enseignant.getSexe());
        enseignant1.setAdresse(enseignant.getAdresse());
        enseignant1.setEmail(enseignant.getEmail());
        enseignant1.setDateNaissance(enseignant.getDateNaissance());
        enseignant1.setDateUpdate(new Date());
        enseignant1.setSpecialite(enseignant.getSpecialite());
        enseignant1.setDateUpdate(enseignant.getDateUpdate());

        Enseignant enseignant2=enseignantRepo.save(enseignant1);

        if (enseignant2==null){
            throw new Exceptions(Exceptions.alertGeneralException("echoué"));
        }

    }

    @Override
    public Enseignant getById(Long id) throws Exceptions {
        if(!isPresent(id))
            throw new Exceptions(Exceptions.alertGeneralException("l'identifiant n'existe pas"));
        Optional<Enseignant> opad=enseignantRepo.findById(id);
        return  opad.get();
    }
    public boolean isPresent(Long id){
        Optional<Enseignant> opab=enseignantRepo.findById(id);
        if (opab.isPresent())
            return true;
        return false;
    }


}
