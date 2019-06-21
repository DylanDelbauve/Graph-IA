package grapheffect_ia.Modules.AutomateModuleDecision;

import grapheffect_ia.Modules.Module_Decision;

/**
 * Etat où L'IA doit fabriquer des vaisseaux
 * @author delbauve
 */
public class Etat_Fabrication extends Etat {
    public Etat_Fabrication(Module_Decision module_decision) {
        super(module_decision);
    }

    @Override
    public String messageAEnvoyer() {
        return "FABRIQUER|Explorateur";
    }

    @Override
    public Etat transition() {
        this.getModuleMemoire().ajouterVaisseau();
        return new Etat_GestionDesVaisseaux(this.getModule());
    }
}
