package fr.calculEssence.application.tools;

import fr.calculEssence.application.entities.Personne;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class GererEssence {
    public void ajoutVoyage(ArrayList<Personne> listPersonne, Scanner scanner) throws IOException {

        CadreSortie.Cadre(" Vous souhaitez ajouter un voyage");
        int valide = 0;
        Personne conducteur;
        List<Personne> passagers;
        float prixEssence;
        String dateTrajet;
        do {
            //get conducteur
            System.out.println("Qui était le conducteur?");
            int i = 1;
            for (Personne personne : listPersonne) {
                System.out.println("Si le conducteur était " + personne.getNom() + " taper " + i);
                i++;
            }
            int choixConducteur = 0;
            try {
                choixConducteur = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.err.println("Vous n'avez pas saisi une bonne valeur");
            }
            conducteur = listPersonne.get(choixConducteur - 1);
            System.out.println("Le conducteur est " + conducteur.getNom());


            //Get passagers
            ArrayList<Personne> listPersonneSansConducteur = listPersonne;
            listPersonneSansConducteur.remove(choixConducteur - 1);
            passagers = new ArrayList<>();
            int estIlPassager = 0;
            for (Personne personne : listPersonneSansConducteur) {
                System.out.println("Est-ce que " + personne.getNom() + " était passager de ce voyage ?\n si oui tapez 1 sinon 0");
                do {
                    try {
                        estIlPassager = scanner.nextInt();
                    } catch (InputMismatchException e) {
                        System.err.println("Vous n'avez pas saisi une bonne valeur");
                    }
                } while (estIlPassager < 0 || estIlPassager > 1);
                if (estIlPassager == 1) {
                    passagers.add(personne);
                }
            }

            //get prix essence
            System.out.println("Quel est le prix actuel de l'essence utilisé pour le trajet?");
            prixEssence = 0;
            do {
                try {
                    prixEssence = scanner.nextFloat();
                } catch (InputMismatchException e) {
                    System.err.println("Vous n'avez pas saisi une bonne valeur");
                }
            } while (prixEssence < 0);
            System.out.println("Le prix de l'essence est " + prixEssence + " €");

            //get Date
            System.out.println("Quel est la date du trajet?");
            dateTrajet = null;
            do {
                try {
                    dateTrajet = scanner.nextLine();
                } catch (InputMismatchException e) {
                    System.err.println("Vous n'avez pas saisi une bonne valeur");
                }
            } while (dateTrajet == null);
            System.out.println("La date du trajet est " + dateTrajet);


            //Validation du trajet
            System.out.println("Avant de passer au calcul, veuillez confirmer ces infos:\n Le conducteur est :" + conducteur.getNom());
            for (Personne personne : passagers) {
                System.out.println(personne.getNom() + " est passager de ce voyage");
            }
            System.out.println("Le prix de l'essence est " + prixEssence + " €");
            System.out.println("La date du trajet est " + dateTrajet);

            System.out.println("Si toutes ces infos vous conviennent tapez 1 sinon 0");
            try {
                valide = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.err.println("Vous n'avez pas saisi une bonne valeur");
            }

        } while (valide == 0);
        this.calculEssence(conducteur, passagers, prixEssence, dateTrajet, listPersonne);


        CadreSortie.Cadre(" Vous allez être redirigé vers le menu.");
        PressEnterToContinue.Press(scanner);
    }

    private void calculEssence(Personne conducteur, List<Personne> passagers, float prixEssence, String dateTrajet, ArrayList<Personne> listPersonne) throws IOException {
        int kilometre = 50;
        int consommationAuCent = 6;

        float prixTotal = prixEssence * consommationAuCent / kilometre;

        int nbPassagers = passagers.size() + 1;
        float prixParPassager = prixTotal / nbPassagers;
        conducteur.setDette(conducteur.getDette()-prixParPassager);
        for (Personne passager: passagers) {
            passager.setDette(passager.getDette()-prixParPassager);
        }

        //Rajouter dans listPersonne
        //Rajouter dans l'historique
        //Sauvergader les dettes
        Sauvegarde.sauvegarderDette(listPersonne);
        CadreSortie.Cadre(" Nouvelle dette sauvegardé");
        //Sauvegarder l'historique
    }


}
