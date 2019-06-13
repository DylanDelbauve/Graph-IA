package grapheffect_ia.Modules;

import grapheffect_ia.IA;
import grapheffect_ia.Metier.Carte.Carte;
import grapheffect_ia.Metier.Carte.Coordonnee;
import grapheffect_ia.Metier.Vaisseaux.Vaisseau;

import java.util.ArrayList;

/**
 * Module en charge de la mémorisation et de la restitution des informations obtenues
 * @author Matthieu
 */
public class Module_Memoire extends Module  {
    private Carte carte;
    private Coordonnee coordonnee_Base;
    private ArrayList<Vaisseau> vaisseaux = new ArrayList<>();
    private boolean carteAJour;

    public Module_Memoire(IA ia) {
        super(ia);
    }

    public void genererCarte(String messageRecu) {
        carte = new Carte(messageRecu);
        carteAJour = true;
    }

    public boolean hasCarte() {
        return this.carte!=null;
    }

    public void setBase(String message) {
        this.coordonnee_Base = Coordonnee.fromString(message);
    }

    public boolean hasBase() {
        return coordonnee_Base != null;
    }

    public ArrayList<Vaisseau> getVaisseaux() {
        return vaisseaux;
    }

    public void ajouterVaisseau() {
        vaisseaux.add(new Vaisseau(coordonnee_Base));
    }

    public boolean getCarte() {
        return carteAJour;
    }

    public void setCarteAJour(boolean carteAJour) {
        this.carteAJour = carteAJour;
    }
}
