package grapheffect_ia.Metier.Carte.Cases;

import grapheffect_ia.Metier.Carte.Coordonnee;

public class FabriqueCase {

    public static Case Creer(Coordonnee coordonnee, Character lettre) {
        Case c;
        switch (lettre) {
            case 'A' : c = new Case_Asteroides(coordonnee);
                    break;
            case 'E' : c = new Case_Espace(coordonnee);
                    break;
            case 'S' : c = new Case_Etoile(coordonnee);
                    break;
            case 'P' : c = new Case_Planete(coordonnee);
                    break;
            case 'X' : c = new Case_Inconnue(coordonnee);
                    break;
            default: c = new Case_Inconnue(coordonnee);
                    break;

        }
        return c;
    }
}
