package fr.calculEssence.application.entities;

import java.util.ArrayList;

public class Voyage {
    private String conducteur;
    private ArrayList<String> passagers;
    private String date;

    //Prix au L au moment actuel
    private float prixEssence;

    public Voyage(String conducteur, ArrayList<String> passagers, float prixEssence) {
        this.conducteur = conducteur;
        this.passagers = passagers;
        this.prixEssence = prixEssence;
    }

    public Voyage(String conducteur, ArrayList<String> passagers, String date, float prixEssence) {
        this.conducteur = conducteur;
        this.passagers = passagers;
        this.date = date;
        this.prixEssence = prixEssence;
    }

    public String getConducteur() {
        return conducteur;
    }

    public void setConducteur(String conducteur) {
        this.conducteur = conducteur;
    }

    public ArrayList<String> getPassagers() {
        return passagers;
    }

    public void setPassagers(ArrayList<String> passagers) {
        this.passagers = passagers;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public float getPrixEssence() {
        return prixEssence;
    }

    public void setPrixEssence(float prixEssence) {
        this.prixEssence = prixEssence;
    }


    @Override
    public String toString() {
        return "Le voyage a eu lieu le " +date +
                ". Le conducteur était " + conducteur +
                ". Il y avait comme passagers " + passagers +
                ". Le prix de l'essence était " + prixEssence ;
    }
}
