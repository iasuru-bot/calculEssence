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
        System.out.println(personneAvecSoldeAModifier.toString());

        PressEnterToContinue.Press(scanner);
        //Get nouveau solde
        int valide = 0;
        int nouveauSolde;
        do {
            System.out.println("Le solde actuel de " + personneAvecSoldeAModifier.getNom() + " est de " + personneAvecSoldeAModifier.getDette());
            CadreSortie.Cadre("Entrez la nouvelle valeur du solde de " + personneAvecSoldeAModifier.getNom());

            nouveauSolde = 0;
            try {
                nouveauSolde = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.err.println("Vous n'avez pas saisi une bonne valeur");
            }

            System.out.println("Le solde actuel de " + personneAvecSoldeAModifier.getNom() + " est de " + nouveauSolde);

            System.out.println("Entrez 1 si cela vous convient 0 sinon");
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
