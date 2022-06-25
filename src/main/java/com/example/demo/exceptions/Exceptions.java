package com.example.demo.exceptions;
/**
 * @author Amemorte //KOISONN MANES MANA
 * @since 28/05/2022
 * @version 1
 */
public class Exceptions extends Exception {

    public Exceptions(String message) {
        super(message);
    }

    public static String alertGeneralException(String message){return message;}

    public static String libelleNotFound(String libelle){
        return "libelle :"+libelle+" existe";
    }



}
