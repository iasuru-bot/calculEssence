package fr.calculEssence.application.tools;

import fr.calculEssence.application.entities.Historique;
import fr.calculEssence.application.entities.Personne;
import fr.calculEssence.application.entities.Voyage;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Sauvegarde {
    public static void sauvegarderDette(ArrayList<Personne> listPersonne) throws IOException {
        FileWriter fw = new FileWriter("src/Dettes.txt");
        for (Personne personne : listPersonne) {
            double dette = (Math.round(personne.getDette() * 100.0) / 100.0);
            fw.write(personne.getNom() + ";" + dette + "\n");
        }
        fw.close();
    }

    public static void sauvegarderHistorique(Historique historique) throws IOException {
        FileWriter fh = new FileWriter("src/Historique.txt");

        for (Voyage voyage : historique.getLogs()) {
            String response = voyage.getConducteur() + ";";
            for (String nomPassager : voyage.getPassagers()) {
                response += nomPassager + ",";
            }
            if (voyage.getPassagers().size() > 0) {
                response = response.replaceFirst(".$", "");
            }
            response += ";" + voyage.getPrixEssence() + ";" + voyage.getDate();
            fh.write(response + "\n");
        }
        fh.close();
    }
}
