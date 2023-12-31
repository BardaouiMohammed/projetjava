package services;

import controllers.DepartementsController;
import models.Departement;
import models.Enseignant;

import java.util.ArrayList;

public class servicesEnseignant {
    public static Enseignant addEns(String nom, String prenom, String email, String grade, Departement departement) {
        Enseignant enseignant = new Enseignant();
        enseignant.setNom(nom);
        enseignant.setPrenom(prenom);
        enseignant.setGrade(grade);
        enseignant.setEmail(email);
        enseignant.setDept(departement);
        return  new Enseignant();

    }

    public static Enseignant updateEns(int id, String nom, String prenom, String email, String grade, Departement departement) {
        for (Enseignant enseignant : DB.enseignants) {
            if (enseignant.getId() == id) {
                enseignant.setNom(nom);
                enseignant.setPrenom(prenom);
                enseignant.setGrade(grade);
                enseignant.setEmail(email);
                enseignant.setDept(departement);
            }
            return enseignant;
        }
        return new Enseignant();
    }

    public static Enseignant getEnsbyid(int id) {
        for (Enseignant enseignant : DB.enseignants) {
            if (enseignant.getId() == id) {
                return enseignant;
            }
        }
        return new Enseignant();
    }

    public static ArrayList<Enseignant> deleteEnsbyid(int id) {
        DB.enseignants.remove(getEnsbyid(id));
        return DB.enseignants;
    }
    public static ArrayList<Enseignant> getAllEns(){
        return DB.enseignants;
    }
}