package grapheffect_ia.Modules.AutomateModuleDecision;

import grapheffect_ia.Metier.Vaisseaux.Vaisseau;
import grapheffect_ia.Modules.Module_Decision;

/**
 * Etat où l'IA doit effectuer les mouvements des vaisseaux
 * @author delbauve
 */
public class Etat_Mouvement extends Etat {
    private Vaisseau vaisseau;

    public Etat_Mouvement(Module_Decision module_decision, Vaisseau vaisseau) {
        super(module_decision);
        this.vaisseau = vaisseau;
    }

    @Override
    public String messageAEnvoyer() {
        String s = "MOUVEMENT|";
        if (vaisseau.getOrdre() != null && vaisseau.peutFaireOrdre())
            s+= vaisseau.getNom()+"|"+vaisseau.getOrdre();
        else
            s = "";
        return s;
    }

    @Override
    public Etat transition() {
        if (vaisseau.getOrdre() != null)
            vaisseau.faireOrdre();
        this.getModuleMemoire().setCarteAJour(! vaisseau.besoinMiseAJourCarte());
        Etat res = (this.getModuleMemoire().hasCarte()) ? new Etat_BesoinVaisseau(this.getModule()) : new Etat_Carte(this.getModule());
        return res;
    }
}
