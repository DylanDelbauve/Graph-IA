package grapheffect_ia.Modules.AutomateModuleDecision;

import grapheffect_ia.Metier.Algo.ParcoursExploration;
import grapheffect_ia.Metier.Algo.ParcoursLargeur;
import grapheffect_ia.Metier.Carte.Cases.Case;
import grapheffect_ia.Metier.Carte.Cases.Case_Inconnue;
import grapheffect_ia.Metier.Carte.Coordonnee;
import grapheffect_ia.Metier.Vaisseaux.Vaisseau;
import grapheffect_ia.Modules.Module_Decision;

/**
 * Etat où l'IA doit faire un choix sur la destination des vaisseaux
 * @author delbauve
 */
public class Etat_ChoixDestination extends  Etat {
    private Vaisseau vaisseau;

    public Etat_ChoixDestination(Module_Decision module_decision, Vaisseau vaisseau) {
        super(module_decision);
        this.vaisseau = vaisseau;
    }

    @Override
    public String messageAEnvoyer() {
        return "";
    }

    @Override
    public Etat transition() {
       Case caseVaisseau = this.getModuleMemoire().getCarte().getCase(vaisseau.getPosition());
       Case caseBase = this.getModuleMemoire().getCaseBase();
        ParcoursExploration parcours = new ParcoursExploration(this.getModuleMemoire().getCarte());
        parcours.calculer(caseVaisseau, caseBase);
        Case destination = this.getModuleMemoire().getCarte().getCase(vaisseau.getDestination());
        if (destination == null || !destination.isAccessible() || destination == caseVaisseau) {
            destination = parcours.getCaseInonnueAVisiter();
            vaisseau.setDestination(destination.getCoordonnee());
        }
        vaisseau.ajouterOrdres(parcours.getChemin(destination));
        return new Etat_Mouvement(this.getModule(),vaisseau);
    }
}
