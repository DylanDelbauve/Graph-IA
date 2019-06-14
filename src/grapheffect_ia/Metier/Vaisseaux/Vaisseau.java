package grapheffect_ia.Metier.Vaisseaux;

import grapheffect_ia.Metier.Carte.Carte;
import grapheffect_ia.Metier.Carte.Cases.Case;
import grapheffect_ia.Metier.Carte.Cases.Case_Inconnue;
import grapheffect_ia.Metier.Carte.Cases.TypeCase;
import grapheffect_ia.Metier.Carte.Coordonnee;
import grapheffect_ia.Metier.Carte.TypeMouvement;

import java.util.ArrayList;

public class Vaisseau {
    private Coordonnee position;
    private ArrayList<TypeMouvement> ordres;
    private int PA;
    private String nom;
    private Carte carte;

    public void setCarte(Carte carte) {
        this.carte = carte;
    }

    public Vaisseau(Coordonnee position, Carte carte) {
        this.position = position;
        this.ordres = new ArrayList<>();
        this.nom = "Explorateur_1";
        this.carte = carte;
        this.PA = 6;
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

    public boolean besoinMiseAJourCarte() {
        boolean res = false;
        for (Case voisin : carte.getCase(this.position).getVoisins()) {
            for (Case v : carte.getCase(voisin.getCoordonnee()).getVoisins()) {
                if (voisin.getType() == TypeCase.INCONNUE)
                    res = true;
            }
        }
        return res;
    }

    public void viderOrdres() {
        this.ordres.clear();
    }
}
