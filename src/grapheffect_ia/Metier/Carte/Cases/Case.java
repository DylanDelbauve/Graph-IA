package grapheffect_ia.Metier.Carte.Cases;

import grapheffect_ia.Metier.Carte.Coordonnee;

import java.util.ArrayList;

/**
 *
 * @author delbauve
 */
public abstract class Case {
    private Coordonnee coordonnee; //Coordonnée de la case
    private ArrayList<Case> voisins; //Liste des voisins de cette case

    /**
     * Créer une case
     * @param coordonnee coordonnée de la case
     */
    public Case(Coordonnee coordonnee) {
        this.coordonnee = coordonnee;
        this.voisins = new ArrayList<>();
    }

    /**
     * Renvoie les coordonnées de la case
     * @return coordonnée de la case
     */
    public Coordonnee getCoordonnee() {
        return coordonnee;
    }

    /**
     * Renvoie le type de la case
     * @return le type de la case
     */
    public abstract TypeCase getType();

    /**
     * Renvoie la liste des voisins
     * @return la liste des voisins
     */
    public ArrayList<Case> getVoisins() {
        return voisins;
    }

    /**
     * Ajoute un voisin de la case
     * @param voisin la case voisine
     */
    public void ajouterVoisin(Case voisin) {
        this.voisins.add(voisin);
    }

    /**
     * Renvoie vrai si la case est accessible
     * @return
     */
    public abstract boolean isAccessible();
    
}
