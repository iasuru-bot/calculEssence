package fr.calculEssence.application.tools;

import fr.calculEssence.application.entities.Personne;

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

    public void changerSoldes(ArrayList<Personne> listPersonne, Scanner scanner) {

        CadreSortie.Cadre(" Vous souhaitez changez les dettes d'une personne.");

        for (Personne personne : listPersonne) {
            System.out.println("tape");
        }


        CadreSortie.Cadre(" Vous allez être redirigé vers le menu.");
        PressEnterToContinue.Press(scanner);
    }
}
