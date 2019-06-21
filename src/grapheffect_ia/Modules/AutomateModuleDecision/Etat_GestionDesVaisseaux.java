package grapheffect_ia.Modules.AutomateModuleDecision;

import grapheffect_ia.Metier.Vaisseaux.Vaisseau;
import grapheffect_ia.Modules.Module_Decision;

/**
 * Etat où l'IA gère les déplacements des vaisseaux
 * @author delbauve
 */
public class Etat_GestionDesVaisseaux extends Etat {
    public Etat_GestionDesVaisseaux(Module_Decision module_decision) {
        super(module_decision);
    }

    @Override
    public String messageAEnvoyer() {
        return "";
    }

    @Override
    public Etat transition() {
        this.getModuleMemoire().vaisseauSuivant();
        Etat nouvelEtat = new Etat_FinDeTour(getModule());
        int sommePA = 0;
        for(Vaisseau v : this.getModuleMemoire().getVaisseaux()) {
            sommePA += v.getPA(); }
        if(sommePA > 0) {
            while(this.getModuleMemoire().getVaisseauEnCours().getPA() == 0) {
                this.getModuleMemoire().vaisseauSuivant();
            }
            nouvelEtat = new Etat_Mouvement(getModule(),this. getModuleMemoire().getVaisseauEnCours());
            if(this.getModuleMemoire().getVaisseauEnCours().getOrdre() == null) {
                nouvelEtat = new Etat_ChoixDestination(getModule(), this.getModuleMemoire().getVaisseauEnCours());
            }
        }
        return nouvelEtat;
    }
}
