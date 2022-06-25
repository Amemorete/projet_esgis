package com.example.demo.repositories;



import com.example.demo.entities.Absence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Amemorte //KOISONN MANES MANA
 * @since 28/05/2022
 * @version 1
 */
@Repository
public interface AbsenceRepo extends JpaRepository<Absence,Long> {

}
