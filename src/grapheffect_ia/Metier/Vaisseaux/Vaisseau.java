package grapheffect_ia.Metier.Vaisseaux;

import grapheffect_ia.Metier.Carte.Carte;
import grapheffect_ia.Metier.Carte.Cases.Case;
import grapheffect_ia.Metier.Carte.Cases.Case_Inconnue;
import grapheffect_ia.Metier.Carte.Cases.TypeCase;
import grapheffect_ia.Metier.Carte.Coordonnee;
import grapheffect_ia.Metier.Carte.TypeMouvement;
import grapheffect_ia.Modules.Module_Memoire;

import java.util.ArrayList;

public class Vaisseau {
    private Coordonnee position;
    private ArrayList<TypeMouvement> ordres;
    private int PA;
    private String nom;
    private Carte carte;
    private Coordonnee destination;
    private Module_Memoire moduleMemoire;

    public Coordonnee getDestination() {
        return destination;
    }

    public void setDestination(Coordonnee destination) {
        this.destination = destination;
    }

    public void setCarte(Carte carte) {
        this.carte = carte;
    }

    public Vaisseau(Coordonnee position, Carte carte, int numero, Module_Memoire moduleMemoire) {
        this.position = position;
        this.ordres = new ArrayList<>();
        this.nom = "Explorateur_"+numero;
        this.carte = carte;
        this.PA = 6;
        this.moduleMemoire = moduleMemoire;
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
        if (this.peutFaireOrdre()) {
            position = position.voisin(getOrdre());
            ordres.remove(0);
        }
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

    public boolean peutFaireOrdre() {
        boolean res = false;
        if (!ordres.isEmpty() && moduleMemoire.positionLibre(destination))
            res = true;
        return res;
    }
}
