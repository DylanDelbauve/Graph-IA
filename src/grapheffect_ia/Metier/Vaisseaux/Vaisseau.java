package grapheffect_ia.Metier.Vaisseaux;

import grapheffect_ia.Metier.Carte.Carte;
import grapheffect_ia.Metier.Carte.Cases.Case;
import grapheffect_ia.Metier.Carte.Cases.Case_Inconnue;
import grapheffect_ia.Metier.Carte.Cases.TypeCase;
import grapheffect_ia.Metier.Carte.Coordonnee;
import grapheffect_ia.Metier.Carte.TypeMouvement;
import grapheffect_ia.Modules.Module_Memoire;

import java.util.ArrayList;

/**
 * @author delbauve
 */
public class Vaisseau {
    private Coordonnee position; //les coordonnées du vaisseau
    private ArrayList<TypeMouvement> ordres; //liste des ordres
    private int PA; //les points d'action
    private String nom; //nom du vaisseau
    private Carte carte; //carte du jeu
    private Coordonnee destination; //coordonnées de destination
    private Module_Memoire moduleMemoire; //module mémoire de l'IA

    public Coordonnee getDestination() {
        return destination;
    }

    public void setDestination(Coordonnee destination) {
        this.destination = destination;
    }

    public void setCarte(Carte carte) {
        this.carte = carte;
    }

    /**
     * Créer un vaisseau
     * @param position la position du vaisseau
     * @param carte la carte du jeu
     * @param numero le numéro du vaisseau
     * @param moduleMemoire le module mémoire de l'IA
     */
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

    /**
     * remet les PA à la valeur de base, 6
     */
    public void resetPA() {
        this.PA = 6;
    }

    public TypeMouvement getOrdre() {
        return (!this.ordres.isEmpty()) ? this.ordres.get(0) : null;
    }

    /**
     * Ajoute une liste d'ordres aux ordres du vaisseau
     * @param liste la liste de mouvement
     */
    public void ajouterOrdres(ArrayList<TypeMouvement> liste) {
        this.ordres.addAll(liste);
    }

    /**
     * Exécute les ordres du vaisseau
     */
    public void faireOrdre() {
        if (this.peutFaireOrdre()) {
            position = position.voisin(getOrdre());
            ordres.remove(0);
        }
        PA--;
    }

    /**
     * Renvoie si la carte à besoin d'une mise à jour
     * @return vrai si la carte à besoin d'une mise à jour
     */
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

    /**
     * vide la liste d'ordres
     */
    public void viderOrdres() {
        this.ordres.clear();
    }

    /**
     * Renvoie si l'ordre est possible
     * @return vrai si l'ordre est possible
     */
    public boolean peutFaireOrdre() {
        boolean res = false;
        if (getOrdre() != null && moduleMemoire.positionLibre(destination))
            res = true;
        return res;
    }
}
