package grapheffect_ia.Modules.AutomateModuleDecision;

import grapheffect_ia.Metier.Algo.ParcoursExploration;
import grapheffect_ia.Metier.Algo.ParcoursLargeur;
import grapheffect_ia.Metier.Carte.Cases.Case;
import grapheffect_ia.Metier.Carte.Cases.Case_Inconnue;
import grapheffect_ia.Metier.Carte.Coordonnee;
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
       Case caseVaisseau = this.getModuleMemoire().getCarte().getCase(this.getModuleMemoire().getVaisseaux().get(0).getPosition());
       Case caseBase = this.getModuleMemoire().getCaseBase();
        ParcoursExploration parcours = new ParcoursExploration(this.getModuleMemoire().getCarte());
        parcours.calculer(caseVaisseau, caseBase);
        Case destination = parcours.getCaseInonnueAVisiter();
        this.getModuleMemoire().getVaisseaux().get(0).ajouterOrdres(parcours.getChemin(destination));
        return new Etat_Mouvement(this.getModule());
    }
}
