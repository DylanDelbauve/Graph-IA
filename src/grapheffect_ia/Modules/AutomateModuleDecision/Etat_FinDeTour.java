package grapheffect_ia.Modules.AutomateModuleDecision;

import grapheffect_ia.Modules.Module_Decision;

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
        return new Etat_GestionVaisseau(super.getModule());
    }
}
