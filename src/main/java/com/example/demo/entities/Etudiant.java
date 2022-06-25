package com.example.demo.entities;

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
public class Etudiant {

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
        private String filiere;


        @Column(nullable = false)
        private String dateNaissance;

        @CreationTimestamp()
        @Column(nullable = false)
        private Date dateCreate;


        @UpdateTimestamp()
        @Column(nullable = false)
        private Date dateUpdate;


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

        public String getFiliere() {
                return filiere;
        }

        public void setFiliere(String filiere) {
                this.filiere = filiere;
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
                return "Etudiant{" +
                        "id=" + id +
                        ", nom='" + nom + '\'' +
                        ", prenom='" + prenom + '\'' +
                        ", sexe='" + sexe + '\'' +
                        ", adresse='" + adresse + '\'' +
                        ", email='" + email + '\'' +
                        ", filiere='" + filiere + '\'' +
                        ", dateNaissance='" + dateNaissance + '\'' +
                        ", dateCreate=" + dateCreate +
                        ", dateUpdate=" + dateUpdate +
                        '}';
        }
}
