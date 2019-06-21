package grapheffect_ia.Metier.Algo;

import grapheffect_ia.Metier.Carte.Carte;
import grapheffect_ia.Metier.Carte.Cases.Case;
import grapheffect_ia.Metier.Carte.Coordonnee;
import grapheffect_ia.Metier.Carte.TypeMouvement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 *
 * @author delbauve
 */
public class ParcoursLargeur {

    private HashMap<Case,Integer> distances; //Liste de la distance des cases
    private Carte carte; //Carte du jeu

    /**
     * Créer un parcours des cases de la map
     * @param carte carte du jeu
     */
    public ParcoursLargeur(Carte carte) {
        this.carte = carte;
        this.distances = new HashMap<>();
    }

    /**
     * Calcule la distance des cases par rapport à une case de départ
     * @param depart Case de départ
     */
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

    /**
     * Récupère la distance de la Case dans distances
     * @param c la case à tester
     * @return la distance
     */
    public int getDistance(Case c) {
        return distances.get(c);
    }

    private TypeMouvement mouvement(Case depart, Case arrivee) {
        TypeMouvement res = null;
        for (TypeMouvement v : TypeMouvement.values() ) {
            if (depart.getCoordonnee().voisin(v).equals(arrivee.getCoordonnee()))
                res = v;
        }
        return res;
    }

    /**
     * Renvoi le chemin jusqu'à la case arrivée
     * @param arrivee la Case d'arrivée
     * @return une liste des mouvements
     */
    public ArrayList<TypeMouvement> getChemin(Case arrivee) {
        ArrayList<TypeMouvement> resultat = new ArrayList<>();
        Case caseEnCours = arrivee;

        while (distances.get(caseEnCours) > 0) {
            Case casePrecedent = null;
            for (Case v : caseEnCours.getVoisins()) {
                if (this.distances.get(v) == getDistance(caseEnCours) - 1)
                    casePrecedent = v;
            }
            resultat.add(mouvement(casePrecedent,caseEnCours));
            caseEnCours = casePrecedent;
        }
        Collections.reverse(resultat);
        if (distances.get(arrivee) == null || distances.get(arrivee) == -1)
            resultat.clear();
        return resultat;
    }

    /**
     * Teste si la case est atteignable par rapport à la case de départ
     * @param c la case à tester
     * @return vrai ou faux si la case est atteignable
     */
    public boolean estAtteignable(Case c) {
        boolean res = false;
        if (getDistance(c) != -1)
            res = true;
        return res;
    }
}
