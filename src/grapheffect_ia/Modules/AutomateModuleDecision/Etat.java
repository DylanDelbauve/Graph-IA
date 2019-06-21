package grapheffect_ia.Modules.AutomateModuleDecision;

import grapheffect_ia.Modules.Module_Decision;
import grapheffect_ia.Modules.Module_Memoire;

/**
 * @author delbauve
 */
public abstract class Etat {
    private Module_Decision module_decision; //module décision de l'IA

    /**
     * Créer un état abstrait
     * @param module_decision le module de décision
     */
    public Etat(Module_Decision module_decision) {
        this.module_decision = module_decision;
    }
    public Module_Decision getModule() {
        return module_decision;
    }

    public Module_Memoire getModuleMemoire() {
        return module_decision.getIA().getModuleMemoire();
    }

    /**
     * Renvoie le message à envoyer au serveur
     * @return le message à envoyer
     */
    public abstract String messageAEnvoyer();

    /**
     * Renvoie le prochain état
     * @return le prochain état
     */
    public abstract Etat transition();
}
