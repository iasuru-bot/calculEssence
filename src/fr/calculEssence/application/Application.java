package fr.calculEssence.application;

import fr.calculEssence.application.entities.Historique;
import fr.calculEssence.application.entities.Personne;
import fr.calculEssence.application.tools.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) throws IOException {
        //Creation des personnes et de l'historique
        ImportFromFiles importFromFiles = new ImportFromFiles();
        ArrayList<Personne> listPersonne = new ArrayList<>();
        try {
            listPersonne = importFromFiles.CreationPersonne();
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Problème rencontré lors de la création des personnes");
        }
        Historique historique = null;
        try {
            historique = importFromFiles.CreationHistorique();
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Problème rencontré lors de l'historique");
        }

        //accueil du menu
        System.out.println("                  _____       _____\n" +
                "     .........   {     }     {     }\n" +
                "    (>>\\zzzzzz [======================]\n" +
                "    ( <<<\\lllll_\\\\ _        _____    \\\\\n" +
                "   _,`-,\\<   __#:\\\\::_    __#:::_:__  \\\\\n" +
                "  /    . `--,#::::\\\\:::___#::::/__+_\\ _\\\\\n" +
                " /  _  .`-    `--,/_~~~~~~~~~~~~~~~~~~~~  -,_\n" +
                ":,// \\ .         .  '--,____________   ______`-,\n" +
                " :: o |.         .  ___ \\_____||____\\+/     ||~ \\\n" +
                " :;   ;-,_       . ,' _`,\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\\\n" +
                " \\ \\_/ _ :`-,_   . ; / \\\\ ====================== /\n" +
                "  \\__/~ /     `-,.; ; o |\\___[~~~]_ASCII__[~~~]__:\n" +
                "     ~~~          ; :   ;~ ;  ~~~         ;~~~::;\n" +
                "                   \\ \\_/ ~/               ::::::;\n" +
                "                    \\_/~~/                 \\:::/\n" +
                "                      ~~~                   ~~~");

        CadreSortie.Cadre(" Bonjour et bienvenue dans Calcul d'Essence 3000, le calculateur préféré de ton essence préféré.");


        //Menu

        boolean fin = false;
        Scanner scanner = new Scanner(System.in);
        PressEnterToContinue.Press(scanner);
        do {

            //Affichage menu
            CadreSortie.Cadre(" Veuillez choisir une proposition: \n 1-Voir les dettes \n 2-Gérer les dettes\n 3-Voir l'historique des voyages\n 4-Ajouter un trajet \n 5-Quitter");
            int choix = 0;
            try {
                choix = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.err.println("Vous n'avez pas saisi une valeur chiffrée");
            }

            switch (choix) {
                case 1 -> {
                    GererDette gererDette = new GererDette();
                    gererDette.voirSoldes(listPersonne, scanner);
                }
                case 2 -> {
                    GererDette gererDette = new GererDette();
                    gererDette.changerSoldes(listPersonne, scanner);
                }
                case 3 -> {

                }
                case 4 -> {
                    GererEssence gererEssence = new GererEssence();
                    gererEssence.ajoutVoyage(listPersonne, scanner);

                }
                case 5 -> fin = true;
                default -> CadreSortie.Cadre(" Les informations rentrées sont invalides.");
            }
        } while (!fin);
    }
}
