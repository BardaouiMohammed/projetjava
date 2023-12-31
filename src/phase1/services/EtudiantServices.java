package services;

import models.Enseignant;
import models.Etudiant;
import models.Filiere;

import java.util.ArrayList;

public class EtudiantServices {

    public static Etudiant addEtd(String nom, String prenom, String email, int apogee, Filiere filiere){
        Etudiant etudiant = new Etudiant();
        etudiant.setNom(nom);
        etudiant.setPrenom(prenom);
        etudiant.setApogee(apogee);
        etudiant.setEmail(email);
        etudiant.setFiliere(filiere);
        return  new Etudiant();
    }

    public static Etudiant updateEtd(int id,String nom, String prenom, String email, int apogee, Filiere filiere){
        for (Etudiant etudiant : DB.etudiants) {
            if (etudiant.getId() == id) {
                etudiant.setNom(nom);
                etudiant.setPrenom(prenom);
                etudiant.setApogee(apogee);
                etudiant.setEmail(email);
                etudiant.setFiliere(filiere);
            }
            return etudiant;
        }
        return  new Etudiant();
    }


    public static Etudiant getEtdById(int id){
        for (Etudiant etudiant : DB.etudiants) {
            if (etudiant.getId() == id) {
                return etudiant;
            }
        }
        return  new Etudiant();
    }
    public static ArrayList<Etudiant> deleteEtdById(int id){
        DB.etudiants.remove(getEtdById(id));
        return DB.etudiants;
        
    }
    public static ArrayList<Etudiant> getAllEtd(){
        return  DB.etudiants;
    }
}