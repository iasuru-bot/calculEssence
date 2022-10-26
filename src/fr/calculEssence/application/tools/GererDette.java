package fr.calculEssence.application.tools;

import fr.calculEssence.application.entities.Personne;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GererDette {

    public void voirSoldes(ArrayList<Personne> listPersonne, Scanner scanner) {
        for (Personne personne : listPersonne) {
            CadreSortie.Cadre(personne.toString());
        }

        CadreSortie.Cadre(" Vous allez être redirigé vers le menu.");
        PressEnterToContinue.Press(scanner);
    }

    public void changerSoldes(ArrayList<Personne> listPersonne, Scanner scanner) throws IOException {

        CadreSortie.Cadre(" Vous souhaitez changez les dettes d'une personne.");

        int i = 1;
        for (Personne personne : listPersonne) {
            System.out.println("Si vous souhaitez changer la dette de " + personne.getNom() + " taper " + i);
            i++;
        }
        int choixPersonne = 0;
        try {
            choixPersonne = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.err.println("Vous n'avez pas saisi une bonne valeur");
        }
        Personne personneAvecSoldeAModifier = listPersonne.get(choixPersonne - 1);
        listPersonne.remove(choixPersonne - 1);

        PressEnterToContinue.Press(scanner);
        //Get nouveau solde
        int valide = 0;
        float nouveauSolde;
        do {
            System.out.println("Le solde actuel de " + personneAvecSoldeAModifier.getNom() + " est de " + personneAvecSoldeAModifier.getDette());
            CadreSortie.Cadre("Entrez la nouvelle valeur du solde de " + personneAvecSoldeAModifier.getNom());

            nouveauSolde = 0;
            try {
                nouveauSolde = scanner.nextFloat();
            } catch (InputMismatchException e) {
                System.err.println("Vous n'avez pas saisi une bonne valeur");
            }

            CadreSortie.Barre();
            System.out.println("Le solde actuel de " + personneAvecSoldeAModifier.getNom() + " est de " + nouveauSolde);

            System.out.println("Entrez 1 si cela vous convient 0 sinon");

            CadreSortie.Barre();
            try {
                valide = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.err.println("Vous n'avez pas saisi une bonne valeur");
            }

        } while (valide == 0);
        personneAvecSoldeAModifier.setDette(nouveauSolde);
        listPersonne.add(personneAvecSoldeAModifier);
        Sauvegarde.sauvegarderDette(listPersonne);
        CadreSortie.Cadre(" Nouvelle dette sauvegardé");
        CadreSortie.Cadre(" Vous allez être redirigé vers le menu.");
        PressEnterToContinue.Press(scanner);
    }
}
