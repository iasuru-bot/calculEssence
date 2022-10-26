package fr.calculEssence.application.tools;

import fr.calculEssence.application.entities.Historique;
import fr.calculEssence.application.entities.Personne;
import fr.calculEssence.application.entities.Voyage;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class GererEssence {
    // Creating an object of DecimalFormat class
    DecimalFormat df_obj = new DecimalFormat("#.##");

    public void ajoutVoyage(ArrayList<Personne> listPersonne, Historique historique, Scanner scanner) throws IOException {

        CadreSortie.Cadre(" Vous souhaitez ajouter un voyage");
        int valide = 0;
        Personne conducteur;
        List<Personne> passagers;
        float prixEssence;
        String dateTrajet;
        ArrayList<Personne> nonPassagers;
        do {
            CadreSortie.Barre();
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
            CadreSortie.Barre();


            //Get passagers
            ArrayList<Personne> listPersonneSansConducteur = new ArrayList<>();
            for (Personne personne :
                    listPersonne) {
                if (conducteur.getNom() != personne.getNom()) {
                    listPersonneSansConducteur.add(personne);
                }
            }
            passagers = new ArrayList<>();

            nonPassagers = new ArrayList<>();
            int estIlPassager = 0;
            for (Personne personne : listPersonneSansConducteur) {

                CadreSortie.Barre();
                System.out.println("Est-ce que " + personne.getNom() + " était passager de ce voyage ?\nSi oui tapez 1 sinon 0");
                do {
                    try {
                        estIlPassager = scanner.nextInt();
                    } catch (InputMismatchException e) {
                        System.err.println("Vous n'avez pas saisi une bonne valeur");
                    }
                } while (estIlPassager < 0 || estIlPassager > 1);
                if (estIlPassager == 1) {
                    passagers.add(personne);
                } else {
                    nonPassagers.add(personne);
                }
            }

            CadreSortie.Barre();

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

            CadreSortie.Barre();

            //get Date
            System.out.println("Quel est la date du trajet?");
            dateTrajet = null;
            do {
                try {
                    dateTrajet = scanner.next();
                } catch (InputMismatchException e) {
                    System.err.println("Vous n'avez pas saisi une bonne valeur");
                }
            } while (dateTrajet == null);
            System.out.println("La date du trajet est " + dateTrajet);

            CadreSortie.Barre();


            //Validation du trajet
            System.out.println("Avant de passer au calcul, veuillez confirmer ces infos:\nLe conducteur est :" + conducteur.getNom());
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

        CadreSortie.Barre();
        this.calculEssence(conducteur, passagers, prixEssence, dateTrajet, nonPassagers, historique);


        CadreSortie.Cadre("Calcul terminé");
        PressEnterToContinue.Press(scanner);
        GererDette gererDette = new GererDette();
        gererDette.voirSoldes(listPersonne, scanner);

    }

    private void calculEssence(Personne conducteur, List<Personne> passagers, float prixEssence, String dateTrajet, ArrayList<Personne> nonPassagers, Historique historique) throws IOException {
        int kilometre = 50;
        int consommationAuCent = 6;


        ArrayList<Personne> listPersonne = new ArrayList<>();
        ArrayList<String> nomPassager = new ArrayList<>();
        double prixTotal = (((prixEssence * consommationAuCent) / 100) * kilometre);
        prixTotal = (Math.round(prixTotal * 100.0) / 100.0);
        int nbPassagers = passagers.size() + 1;
        double prixParPassager = (prixTotal / nbPassagers);
        prixParPassager = (Math.round(prixParPassager * 100.0) / 100.0);
        conducteur.setDette(conducteur.getDette() - prixParPassager + prixTotal);
        listPersonne.add(conducteur);
        for (Personne passager : passagers) {
            passager.setDette(passager.getDette() - prixParPassager);
            listPersonne.add(passager);
            nomPassager.add(passager.getNom());
        }

        //Rajouter dans listPersonne
        for (Personne personne : nonPassagers) {
            listPersonne.add(personne);
        }
        //Sauvegarder les dettes
        Sauvegarde.sauvegarderDette(listPersonne);
        CadreSortie.Cadre(" Nouvelle dette sauvegardé");

        //Rajouter dans historique
        historique.getLogs().add(new Voyage(conducteur.getNom(), nomPassager, dateTrajet, prixEssence));
        //Sauvegarder l'historique
        Sauvegarde.sauvegarderHistorique(historique);
    }


}
