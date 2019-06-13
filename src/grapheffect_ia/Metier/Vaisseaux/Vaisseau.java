package grapheffect_ia.Metier.Vaisseaux;

import grapheffect_ia.Metier.Carte.Coordonnee;
import grapheffect_ia.Metier.Carte.TypeMouvement;

import java.util.ArrayList;

public class Vaisseau {
    private Coordonnee position;
    private ArrayList<TypeMouvement> ordres;
    private int PA;
    private String nom;

    public Vaisseau(Coordonnee position) {
        this.position = position;
        this.ordres = new ArrayList<>();
        this.nom = "Explorateur_1";
    }

    public Coordonnee getPosition() {
        return position;
    }

    public int getPA() {
        return PA;
    }

    public String getNom() {
        return nom;
    }

    public void resetPA() {
        this.PA = 6;
    }

    public TypeMouvement getOrdre() {
        return (!this.ordres.isEmpty()) ? this.ordres.get(0) : null;
    }

    public void ajouterOrdres(ArrayList<TypeMouvement> liste) {
        this.ordres.addAll(liste);
    }

    public void faireOrdre() {
        position = position.voisin(getOrdre());
        ordres.remove(0);
        PA--;
    }
}
