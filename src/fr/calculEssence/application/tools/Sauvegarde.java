package fr.calculEssence.application.tools;

import fr.calculEssence.application.entities.Personne;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Sauvegarde {
    public static void sauvegarderDette(ArrayList<Personne> listPersonne) throws IOException {
        FileWriter fw = new FileWriter("src/Dettes.txt");
        for (Personne personne : listPersonne) {
            fw.write(personne.getNom() + ";" + personne.getDette() + "\n");
        }
        fw.close();
    }
}
