package grapheffect_ia.Modules.AutomateModuleDecision;

import grapheffect_ia.Modules.Module_Decision;

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
        return new Etat_BesoinVaisseau(super.getModule());
    }
}
