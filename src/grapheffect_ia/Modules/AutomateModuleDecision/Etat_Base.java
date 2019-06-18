package grapheffect_ia.Modules.AutomateModuleDecision;

import grapheffect_ia.Modules.Module_Decision;

public class Etat_Base extends Etat {
    public Etat_Base(Module_Decision module_decision) {
        super(module_decision);
    }

    @Override
    public String messageAEnvoyer() {
        return "BASE";
    }

    @Override
    public Etat transition() {
        return new Etat_BesoinVaisseau(this.getModule());
    }
}
