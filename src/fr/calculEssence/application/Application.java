package fr.calculEssence.application;

import fr.calculEssence.application.entities.Historique;
import fr.calculEssence.application.entities.Personne;
import fr.calculEssence.application.tools.ImportFromFiles;

import java.io.IOException;
import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        ImportFromFiles importFromFiles = new ImportFromFiles();
        ArrayList<Personne> listPersonne = new ArrayList<>();
        try{listPersonne= importFromFiles.CreationPersonne();}
        catch (IOException e){
            e.printStackTrace();
            System.err.println("Problème rencontré lors de la création des personnes");
        }

        Historique historique = null;
        try{historique= importFromFiles.CreationHistorique();}
        catch (IOException e){
            e.printStackTrace();
            System.err.println("Problème rencontré lors de la création des personnes");
        }
        

        System.out.println("Hello World");

        System.out.println(historique);
        for (Personne personne : listPersonne) {
            System.out.println(personne);
        }
    }
}
