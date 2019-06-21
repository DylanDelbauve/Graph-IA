package grapheffect_ia.Modules.AutomateModuleDecision;

import grapheffect_ia.Metier.Vaisseaux.Vaisseau;
import grapheffect_ia.Modules.Module_Decision;

/**
 * Etat où l'IA demande la fin du tour
 * @author delbauve
 */
public class Etat_FinDeTour extends Etat {
    public Etat_FinDeTour(Module_Decision module_decision) {
        super(module_decision);
    }

    @Override
    public String messageAEnvoyer() {
        return "FINTOUR";
    }

    @Override
    public Etat transition() {
        for (Vaisseau v: this.getModuleMemoire().getVaisseaux()) {
            v.resetPA();
        }
        return new Etat_GestionDesVaisseaux(this.getModule());
    }
}
