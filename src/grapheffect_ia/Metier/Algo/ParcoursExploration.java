package grapheffect_ia.Metier.Algo;

import grapheffect_ia.Metier.Carte.Carte;
import grapheffect_ia.Metier.Carte.Cases.Case;
import grapheffect_ia.Metier.Carte.Cases.TypeCase;
import grapheffect_ia.Metier.Carte.TypeMouvement;

import java.util.ArrayList;

/**
 *
 * @author delbauve
 */
public class ParcoursExploration {
    private Carte carte; //Carte du jeu
    private ParcoursLargeur parcoursDepuisVaisseau; //Parcours en largeur avec la case du vaisseau en case de départ
    private ParcoursLargeur parcoursDepuisBase; //Parcours en largeur avec la case de la base en case de départ

    /**
     * Parcours d'exploration pour les vaisseaux
     * @param carte carte du jeu
     */
    public ParcoursExploration(Carte carte) {
        this.carte = carte;
        parcoursDepuisBase = new ParcoursLargeur(carte);
        parcoursDepuisVaisseau = new ParcoursLargeur(carte);
    }

    /**
     *
     * @param caseVaisseau
     * @param caseBase
     */
    public void calculer(Case caseVaisseau, Case caseBase) {
        parcoursDepuisVaisseau.calculer(caseVaisseau);
        parcoursDepuisBase.calculer(caseBase);
    }

    /**
     * Donne le chemin de la case du vaisseau à la case passé en paramètre
     * @param arrivee la case d'arrivée
     * @return une liste de mouvement
     */
    public ArrayList<TypeMouvement> getChemin(Case arrivee) {
        return parcoursDepuisVaisseau.getChemin(arrivee);
    }

    /**
     * Parcours les cases et renvoi une case de type INCONNUE
     * @return une case inconnue
     */
    public Case getCaseInonnueAVisiter() {
        Case resultat = null;
        int coutMin = Integer.MAX_VALUE;
        for (Case c : carte.getCases()) {
            if (parcoursDepuisBase.estAtteignable(c) && parcoursDepuisVaisseau.estAtteignable(c) && c.getType() == TypeCase.INCONNUE) {
                int coutDistance = parcoursDepuisBase.getDistance(c) + parcoursDepuisVaisseau.getDistance(c);
                int coutVoisin = 0;
                for (Case v: c.getVoisins()) {
                    if (v.getType() != TypeCase.INCONNUE)
                        coutVoisin++;
                }
                int cout = coutDistance+coutVoisin;
                if (cout < coutMin) {
                    resultat = c;
                    coutMin = cout;
                }
            }
        }
        return resultat;
    }

    /**
     * Permet de savoir si la case est atteignable par le vaisseau
     * @param c la Case à tester
     * @return vrai ou faux
     */
    public boolean estAtteignable(Case c) {
        return parcoursDepuisVaisseau.estAtteignable(c);
    }
}
