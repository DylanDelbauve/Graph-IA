package grapheffect_ia.Metier.Carte.Cases;

import grapheffect_ia.Metier.Carte.Coordonnee;

import java.util.ArrayList;

public abstract class Case {
    private Coordonnee coordonnee;
    private ArrayList<Case> voisins;

    public Case(Coordonnee coordonnee) {
        this.coordonnee = coordonnee;
        this.voisins = new ArrayList<>();
    }

    public Coordonnee getCoordonnee() {
        return coordonnee;
    }

    public abstract TypeCase getType();

    public ArrayList<Case> getVoisins() {
        return voisins;
    }

    public void ajouterVoisin(Case voisin) {
        this.voisins.add(voisin);
    }

    public abstract boolean isAccessible();
    
}
