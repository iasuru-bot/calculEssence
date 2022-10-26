package fr.calculEssence.application.entities;

public class Personne {
    private String nom;
    private double dette;

    public Personne(String nom, double dette) {
        this.nom = nom;
        this.dette = dette;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getDette() {
        return dette;
    }


    public void setDette(double dette) {
        this.dette = dette;
    }



    @Override
    public String toString() {
        float dette2 = (float) (Math.round(this.dette * 100.0) / 100.0);
        String detteString = Float.toString(dette2);
        return "Personne{" +
                "nom='" + nom + '\'' +
                ", dette=" + detteString +
                '}';
    }
}
