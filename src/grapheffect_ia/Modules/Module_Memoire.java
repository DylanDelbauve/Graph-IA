package grapheffect_ia.Modules;

import grapheffect_ia.IA;
import grapheffect_ia.Metier.Carte.Carte;

/**
 * Module en charge de la mémorisation et de la restitution des informations obtenues
 * @author Matthieu
 */
public class Module_Memoire extends Module  {
    private Carte carte;

    public Module_Memoire(IA ia) {
        super(ia);
    }

    public void genererCarte(String messageRecu) {
        carte = new Carte(messageRecu);
    }

    public boolean hasCarte() {
        return this.carte!=null;
    }



}
