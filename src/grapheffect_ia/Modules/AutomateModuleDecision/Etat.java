package grapheffect_ia.Modules.AutomateModuleDecision;

import grapheffect_ia.Modules.Module_Decision;
import grapheffect_ia.Modules.Module_Memoire;

public abstract class Etat {
    private Module_Decision module_decision;

    public Etat(Module_Decision module_decision) {
        this.module_decision = module_decision;
    }

    public Module_Decision getModule() {
        return module_decision;
    }

    public Module_Memoire getModuleMemoire() {
        return module_decision.getIA().getModuleMemoire();
    }

    public abstract String messageAEnvoyer();

    public abstract Etat transition();
}
