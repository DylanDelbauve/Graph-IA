package grapheffect_ia.Modules.AutomateModuleDecision;

import grapheffect_ia.Metier.Algo.ParcoursLargeur;
import grapheffect_ia.Modules.Module_Decision;

public class Etat_ChoixDestination extends  Etat {
    public Etat_ChoixDestination(Module_Decision module_decision) {
        super(module_decision);
    }

    @Override
    public String messageAEnvoyer() {
        return "";
    }

    @Override
    public Etat transition() {
       ParcoursLargeur pL = new ParcoursLargeur(super.getModuleMemoire().getCarte());
        pL.calculer();
    }
}
