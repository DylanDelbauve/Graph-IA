package grapheffect_ia.Modules.AutomateModuleDecision;

import grapheffect_ia.Modules.Module_Decision;

public class Etat_Mouvement extends Etat {
    public Etat_Mouvement(Module_Decision module_decision) {
        super(module_decision);
    }

    @Override
    public String messageAEnvoyer() {
        String s = "MOUVEMENT|";
        if (this.getModuleMemoire().getVaisseaux().get(0).getOrdre() != null)
            s+= this.getModuleMemoire().getVaisseaux().get(0).getNom()+"|"+this.getModuleMemoire().getVaisseaux().get(0).getOrdre();
        else
            s = "";
        return s;
    }

    @Override
    public Etat transition() {
        if (this.getModuleMemoire().getVaisseaux().get(0).getOrdre() != null)
            this.getModuleMemoire().getVaisseaux().get(0).faireOrdre();
        this.getModuleMemoire().setCarteAJour(! this.getModuleMemoire().getVaisseaux().get(0).besoinMiseAJourCarte());
        Etat res = (this.getModuleMemoire().hasCarte()) ? new Etat_GestionVaisseau(this.getModule()) : new Etat_Carte(this.getModule());
        return res;
    }
}
