package com.example.demo.services;


import com.example.demo.entities.Users;
import com.example.demo.exceptions.Exceptions;
import com.example.demo.repositories.UserRepo;
import com.example.demo.serviceinterface.UserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class UserImpl implements UserInterface {


    @Autowired
    private UserRepo userRepo;
    @Override
    public List<Users> getUsers() throws Exceptions {
        return userRepo.findAll() ;
    }

    @Override
    public void addNewUser(Users users) throws Exceptions {
        Users users1=userRepo.save(users);
        if (users1==null)
            throw new Exceptions(Exceptions.alertGeneralException("entrer les données"));

    }

    @Override
    public void deleteUsers(Long usersId) throws Exceptions {
        boolean exists = userRepo.existsById(usersId);
        if(!exists)
            throw  new Exceptions(Exceptions.alertGeneralException("agr dont l id "+usersId+"n'existe pas "));

        userRepo.deleteById(usersId);

    }

    @Override
    public void updateUsers(Long id, Users users) throws Exceptions {
        if(!isPresent(users.getId()))
            throw new Exceptions(Exceptions.alertGeneralException("l'identifiant n'esiste pas"));
        Users users1=getById(users.getId());

        users1.setNom(users.getNom());
        users1.setPrenom(users.getPrenom());
        users1.setSexe(users.getSexe());
        users1.setAdresse(users.getAdresse());
        users1.setEmail(users.getEmail());
        users1.setPassword(users.getPassword());
        users1.setDateNaissance(users.getDateNaissance());
        users1.setAbilite(users.getAbilite());

        Users users2=userRepo.save(users1);

        if (users2==null){
            throw new Exceptions(Exceptions.alertGeneralException("echoué"));
        }

    }

    @Override
    public Users getById(Long id) throws Exceptions {
        if(!isPresent(id))
            throw new Exceptions(Exceptions.alertGeneralException("l'identifiant n'existe pas"));
        Optional<Users> opad=userRepo.findById(id);
        return  opad.get();
    }


    public boolean isPresent(Long id){
        Optional<Users> opab=userRepo.findById(id);
        if (opab.isPresent())
            return true;
        return false;
    }
}
