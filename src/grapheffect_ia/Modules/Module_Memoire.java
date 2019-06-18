package grapheffect_ia.Modules;

import grapheffect_ia.IA;
import grapheffect_ia.Metier.Carte.Carte;
import grapheffect_ia.Metier.Carte.Cases.Case;
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
    private int numVaisseauEnCours = 0;

    public Module_Memoire(IA ia) {
        super(ia);
        carteAJour = false;
    }

    public void genererCarte(String messageRecu) {
        carte = new Carte(messageRecu);
        carteAJour = true;
        for (Vaisseau v: vaisseaux) {
            v.setCarte(carte);
        }
    }

    public boolean hasCarte() {
        return carteAJour;
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
        vaisseaux.add(new Vaisseau(coordonnee_Base, carte,vaisseaux.size()+1,this));
    }

    public Carte getCarte() {
        return carte;
    }

    public void setCarteAJour(boolean carteAJour) {
        this.carteAJour = carteAJour;
        if(!this.carteAJour) {
            for (Vaisseau v : vaisseaux) {
                v.viderOrdres();
            }
        }
    }

    public Case getCaseBase() {
        return carte.getCase(this.coordonnee_Base);
    }

    public Vaisseau getVaisseauEnCours() {
        return vaisseaux.get(numVaisseauEnCours);
    }

    public void vaisseauSuivant() {
        numVaisseauEnCours++;
        numVaisseauEnCours = numVaisseauEnCours % vaisseaux.size();
    }

    public boolean positionLibre(Coordonnee c) {
        boolean res = true;
        for (int i = 0; i < vaisseaux.size(); i++) {
            if (vaisseaux.get(i).getPosition() == c) {
                res = false;
                i = vaisseaux.size();
            }
        }
        return res;
    }
}
