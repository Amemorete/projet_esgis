package com.example.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Amemorte //KOISONN MANES MANA
 * @since 28/05/2022
 * @version 1
 */
@Entity
@Data
@ToString
public class Examen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @CreationTimestamp
    @Column(nullable = false)
    private Date dateCreate;

    @UpdateTimestamp
    @Column(nullable = false)
    private Date dateUpdate;

    @JoinColumn
    private Float note;

    @ManyToOne
    @JoinColumn
    private Etudiant etudiant;
    @ManyToOne
    @JoinColumn
    private Enseignant enseignant;

    @ManyToOne
    @JoinColumn
    private Cours cours;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public Date getDateUpdate() {
        return dateUpdate;
    }

    public void setDateUpdate(Date dateUpdate) {
        this.dateUpdate = dateUpdate;
    }

    public Float getNote() {
        return note;
    }

    public void setNote(Float note) {
        this.note = note;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    public Enseignant getEnseignant() {
        return enseignant;
    }

    public void setEnseignant(Enseignant enseignant) {
        this.enseignant = enseignant;
    }

    public Cours getCours() {
        return cours;
    }

    public void setCours(Cours cours) {
        this.cours = cours;
    }

    public Examen() {

    }

    public Examen(Long id, Date dateCreate, Date dateUpdate, Float note, Etudiant etudiant, Enseignant enseignant, Cours cours) {
        this.id = id;
        this.dateCreate = dateCreate;
        this.dateUpdate = dateUpdate;
        this.note = note;
        this.etudiant = etudiant;
        this.enseignant = enseignant;
        this.cours = cours;
    }

    @Override
    public String toString() {
        return "Examen{" +
                "id=" + id +
                ", dateCreate=" + dateCreate +
                ", dateUpdate=" + dateUpdate +
                ", note=" + note +
                ", etudiant=" + etudiant +
                ", enseignant=" + enseignant +
                ", cours=" + cours +
                '}';
    }
}
