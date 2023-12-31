package controllers;

import services.*;
import  models.Module;

public class ModulesController {
    public static void showMenu(){
        System.out.println("-------------------------[ Modules ]---------------------------");


        System.out.println("1: Pour ajouter un Module");
        System.out.println("2: Pour afficher les Modules");
        System.out.println("3: Pour modifier un Module");
        System.out.println("4: Pour supprimer un Module");
        System.out.println("0: Pour retourner au menu principal");

        //"Veuillez sélectionner une option : ")
        int option = Main.getIntInput("Veuillez sélectionner une option : ");
        switch(option) {
            case 1:
                createModule();
                break;
            case 2:
                showModules();
                break;
            case 3:
                editModule();
                break;
            case 4:
                destroyModule();
                break;
            default:
                Main.showPrincipalMenu();
        }

    }
    public static void showModules(){
        for (Module module : DB.modules) {
            System.out.print("Id : " + module.getId() );
            System.out.print(" | Intitulé : " + module.getIntitule());
            System.out.print(" | filiere : " + module.getFiliere() );
            System.out.print(" | chef : " + module.getChef() );

            System.out.println("");
        }

    }
    public static void createModule(){

        String intitule = Main.getStringInput("Entrez l'intitulé :");
        FilieresController.showFilieres();
        int id = Main.getIntInput("Sélecionnez une filiere  par id :");
        EnseignantsController.showEnseignants();
        int idid = Main.getIntInput("Sélecionnez un professeur/chef par id :");
        ModuleServices.addModule(intitule,EnseignantServices.getEnsById(idid),FiliereServices.getFiliereById(id));

        showModules();
        showMenu();

    }
    public static void editModule(){
        showModules();
        int id = Main.getIntInput("Sélecionnez un Module par id :");
        String intitule = Main.getStringInput("Entrez l'intitulé :");
        FilieresController.showFilieres();
        int idd = Main.getIntInput("Sélecionnez une filiere  par id :");
        EnseignantsController.showEnseignants();
        int idid = Main.getIntInput("Sélecionnez un professeur/chef par id :");
        ModuleServices.updateModule(id,intitule,EnseignantServices.getEnsById(idid),FiliereServices.getFiliereById(idd));

        showModules();
        showMenu();

    }
    public static void destroyModule(){
        showModules();
        int id = Main.getIntInput("Sélecionnez un module par id :");
        ModuleServices.deleteModuleById(id);
      showModules();
    }
}
