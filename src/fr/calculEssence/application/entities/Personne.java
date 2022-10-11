package fr.calculEssence.application.entities;

public class Personne {
    private String nom;
    private int dette;

    public Personne(String nom, int dette) {
        this.nom = nom;
        this.dette = dette;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getDette() {
        return dette;
    }


    public void setDette(int dette) {
        this.dette = dette;
    }

    //TODO a changer
    @Override
    public String toString() {
        return "Personne{" +
                "nom='" + nom + '\'' +
                ", dette=" + dette +
                '}';
    }
}
