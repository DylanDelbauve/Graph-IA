package grapheffect_ia.Modules.AutomateModuleDecision;

import grapheffect_ia.Modules.Module_Decision;

/**
 * Etat où l'IA a besoin de la carte
 * @author delbauve
 */
public class Etat_Carte extends Etat {
    public Etat_Carte(Module_Decision module_decision) {
        super(module_decision);
    }

    @Override
    public String messageAEnvoyer() {
        return "CARTE";
    }

    @Override
    public Etat transition() {
        return (this.getModuleMemoire().hasBase() ? new Etat_BesoinVaisseau(this.getModule()) : new Etat_Base(this.getModule()));
    }
}
