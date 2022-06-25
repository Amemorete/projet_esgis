package com.example.demo.entities;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String prenom;



    @Column(nullable = false)
    private String sexe;


    @Column(nullable = false)
    private String adresse;

    @Column(nullable = false)
    private String email;


    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String abilite;



    @Column(nullable = false)
    private String dateNaissance;

    @CreationTimestamp()
    @Column(nullable = false)
    private Date dateCreate;


    @UpdateTimestamp()
    @Column(nullable = false)
    private Date dateUpdate;


    public Users() {
    }

    public Users(Long id, String nom, String prenom, int age, String sexe, String adresse, String email, String password, String abilite, String dateNaissance, Date dateCreate, Date dateUpdate) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.adresse = adresse;
        this.email = email;
        this.password = password;
        this.abilite = abilite;
        this.dateNaissance = dateNaissance;
        this.dateCreate = dateCreate;
        this.dateUpdate = dateUpdate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }



    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAbilite() {
        return abilite;
    }

    public void setAbilite(String abilite) {
        this.abilite = abilite;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
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

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", sexe='" + sexe + '\'' +
                ", adresse='" + adresse + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", abilite='" + abilite + '\'' +
                ", dateNaissance='" + dateNaissance + '\'' +
                ", dateCreate=" + dateCreate +
                ", dateUpdate=" + dateUpdate +
                '}';
    }
}
