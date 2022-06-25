package com.example.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Amemorte //KOISONN MANES MANA
 * @since 28/05/2022
 * @version 1
 */

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Absence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date date;

    @ManyToOne
    @JoinColumn
    private Etudiant etudiant;

    @ManyToOne
    @JoinColumn
    private Cours cours;
}
