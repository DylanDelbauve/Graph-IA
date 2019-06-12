package grapheffect_ia.Metier.Algo;

import grapheffect_ia.Metier.Carte.Carte;
import grapheffect_ia.Metier.Carte.Cases.Case;
import grapheffect_ia.Metier.Carte.Coordonnee;
import grapheffect_ia.Metier.Carte.TypeMouvement;

import java.util.ArrayList;
import java.util.HashMap;

public class ParcoursLargeur {

    private HashMap<Case,Integer> distances;
    private Carte carte;

    public ParcoursLargeur(Carte carte) {
        this.carte = carte;
        this.distances = new HashMap<>();
    }

    public void calculer(Case depart) {
        ArrayList<Case> aTraiter = new ArrayList<>();
        this.distances.clear();

        aTraiter.add(depart);
        distances.put(depart,0);

        while (!aTraiter.isEmpty()) {
            Case caseEnCours = aTraiter.get(0);
            aTraiter.remove(0);
            for (Case v : caseEnCours.getVoisins()) {
                if (!distances.containsKey(v)) {
                    if (v.isAccessible()) {
                        distances.put(v, distances.get(caseEnCours)+1);
                        aTraiter.add(v);
                    }
                    else {
                        distances.put(v, -1);
                    }
                }
            }
        }
    }

    public int getDistance(Case c) {
        return distances.get(c);
    }

    private TypeMouvement mouvement(Case depart, Case arrivee) {
        Coordonnee c = new Coordonnee(
                arrivee.getCoordonnee().getLigne() - depart.getCoordonnee().getLigne(),
                arrivee.getCoordonnee().getColonne() - depart.getCoordonnee().getColonne());
        TypeMouvement res = null;

        if (c.getColonne() % 2 == 0) {
            switch (c.getLigne() && c.getColonne()) {
                case c.getLigne() == 1 && c.getColonne() == 0: res = TypeMouvement.Bas;
                break;
            }
        }
    }

    public ArrayList<TypeMouvement> getChemin(Case arrivee) {
        ArrayList<TypeMouvement> resultat = new ArrayList<>();
        Case caseEnCours = arrivee;

        while (distances.get(caseEnCours) > 0) {
            Case casePrecedente = null;
            for (int i = 0; i < caseEnCours.getVoisins().size() ; i++) {
                if ( distances.get(caseEnCours.getVoisins().get(i)) == distances.get(caseEnCours) - 1) {
                    casePrecedente = caseEnCours.getVoisins().get(i);
                    i = caseEnCours.getVoisins().size() - 1;
                }
            }

        }
    }


}
