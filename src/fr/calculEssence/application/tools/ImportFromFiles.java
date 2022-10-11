package fr.calculEssence.application.tools;

import fr.calculEssence.application.entities.Historique;
import fr.calculEssence.application.entities.Personne;
import fr.calculEssence.application.entities.Voyage;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ImportFromFiles {

    //méthode permettant de faire créer les personnes et les dettes des personnes.
    public ArrayList<Personne> CreationPersonne() throws IOException {
        Path path = Paths.get("src/Dettes.txt");

        List<String> lignes = Files.readAllLines(path, StandardCharsets.UTF_8);

        ArrayList<Personne> listPersonne = new ArrayList<>();
        for (String ligne : lignes) {
            // On commence par découper la ligne en morceaux sur la base du caractère séparateur « ; » .

            String[] morceaux = ligne.split(";");
            String nomPersonne = morceaux[0];
            String dettePersonne = morceaux[1];

            //création de la personne
            Personne personne = new Personne(nomPersonne, Integer.parseInt(dettePersonne));

            // ajout dans un tableau de personne
            listPersonne.add(personne);
        }
        //return tab de personne
        return listPersonne;
    }


    //méthode permettant de faire créer les personnes et les dettes des personnes.
    public Historique CreationHistorique() throws IOException {
        Path path = Paths.get("src/Historique.txt");

        List<String> lignes = Files.readAllLines(path, StandardCharsets.UTF_8);

        Historique historique = new Historique();
        for (String ligne : lignes) {
            // On commence par découper la ligne en morceaux sur la base du caractère séparateur « ; » .

            String[] morceaux = ligne.split(";");
            String conducteur = morceaux[0];
            String passagers = morceaux[1];
            String prixEssence = morceaux[2];
            String date = morceaux[3];


            String[] tabPassagers = passagers.split(",");
            ArrayList<String> listPassagers = new ArrayList<>();
            for (String passager : tabPassagers) {
                listPassagers.add(passager);
            }
            //création d'un voyage
            Voyage voyage;
            if (date.isBlank()) {
                voyage = new Voyage(conducteur, listPassagers, Float.parseFloat(prixEssence));
            } else {
                voyage = new Voyage(conducteur, listPassagers, date, Float.parseFloat(prixEssence));
            }
            //ajout dans l'historique
            System.out.println(voyage);
            historique.getLogs().add(voyage);

        }
        //return tab de personne
        return historique;
    }
}
