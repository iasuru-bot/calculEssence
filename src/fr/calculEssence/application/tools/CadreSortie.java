package fr.calculEssence.application.tools;

public class CadreSortie {

    //méthode permettant d'afficher un cadre de sortie avec des #
    public static void Cadre(String valeur){
        System.out.println("####################################################################################################");

        String[]tabSplit = valeur.split("\n");

        int longueurCadre=100;
        for (String var:tabSplit) {

            int varLongueur = var.length();
            int tabLongueur= (varLongueur/(longueurCadre-2))+1;

            String[] tab = new String[tabLongueur];
            StringBuilder suffixe= new StringBuilder();
            int j = 0;
            StringBuilder valeurBuilder = new StringBuilder(var);

            for (int i = 0; i < varLongueur; i+=(longueurCadre-2)) {
                if (varLongueur-i < (longueurCadre-2)){
                    suffixe.append(" ".repeat((longueurCadre-2)+i - varLongueur));
                    valeurBuilder.append(suffixe);
                    tab[j]= valeurBuilder.substring(i, (i + (longueurCadre-2))) ;
                }
                else {
                    tab[j] = valeurBuilder.substring(i, (i + (longueurCadre-2)));
                }
                j++;
            }
            for (String s : tab) {
                System.out.println("#" + s + "#");
            }
        }
        System.out.println("####################################################################################################");
    }
}

