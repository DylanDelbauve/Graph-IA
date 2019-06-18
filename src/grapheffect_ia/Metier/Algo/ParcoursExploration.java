package grapheffect_ia.Metier.Algo;

import grapheffect_ia.Metier.Carte.Carte;
import grapheffect_ia.Metier.Carte.Cases.Case;
import grapheffect_ia.Metier.Carte.Cases.TypeCase;
import grapheffect_ia.Metier.Carte.TypeMouvement;

import java.util.ArrayList;

public class ParcoursExploration {
    private Carte carte;
    private ParcoursLargeur parcoursDepuisVaisseau;
    private ParcoursLargeur parcoursDepuisBase;

    public ParcoursExploration(Carte carte) {
        this.carte = carte;
        parcoursDepuisBase = new ParcoursLargeur(carte);
        parcoursDepuisVaisseau = new ParcoursLargeur(carte);
    }

    public void calculer(Case caseVaisseau, Case caseBase) {
        parcoursDepuisVaisseau.calculer(caseVaisseau);
        parcoursDepuisBase.calculer(caseBase);
    }

    public ArrayList<TypeMouvement> getChemin(Case arrivee) {
        return parcoursDepuisVaisseau.getChemin(arrivee);
    }

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

    public boolean estAtteignable(Case c) {
        return parcoursDepuisVaisseau.estAtteignable(c);
    }
}
