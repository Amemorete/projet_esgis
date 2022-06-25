package com.example.demo.repositories;


import com.example.demo.entities.Cours;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Amemorte //KOISONN MANES MANA
 * @since 28/05/2022
 * @version 1
 */
@Repository
public interface CoursRepo  extends JpaRepository<Cours,Long> {
    @Query("SELECT a FROM Cours a WHERE trim(lower(a.libelle)) =trim(lower(?1)) ")
    Optional<Cours> findAgrByLibelle(String libelle);
}
