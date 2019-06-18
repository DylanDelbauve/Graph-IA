package grapheffect_ia.Modules.AutomateModuleDecision;

import grapheffect_ia.Modules.Module_Decision;

public class Etat_BesoinVaisseau extends Etat {
    public Etat_BesoinVaisseau(Module_Decision module_decision) {
        super(module_decision);
    }

    @Override
    public String messageAEnvoyer() {
        return "";
    }

    @Override
    public Etat transition() {
        Etat res = null;
        if (this.getModuleMemoire().getVaisseaux().isEmpty())
            res = new Etat_Fabrication(this.getModule());
        else
            res = new Etat_GestionVaisseau(this.getModule());
        return res;
    }
}
