package grapheffect_ia.Modules.AutomateModuleDecision;

import grapheffect_ia.Modules.Module_Decision;

public class Etat_GestionVaisseau extends Etat {
    public Etat_GestionVaisseau(Module_Decision module_decision) {
        super(module_decision);
    }

    @Override
    public String messageAEnvoyer() {
        return "";
    }

    @Override
    public Etat transition() {
        Etat res = null;
        if (this.getModuleMemoire().getVaisseaux().get(0).getPA() == 0)
            res = new Etat_FinDeTour(this.getModule());
        else if (this.getModuleMemoire().getVaisseaux().get(0).getOrdre() != null)
            res = new Etat_Mouvement(this.getModule());
        else
            res = new Etat_ChoixDestination(this.getModule());
        return res;
    }
}
