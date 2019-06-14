package grapheffect_ia.Modules;

import grapheffect_ia.IA;
import grapheffect_ia.Metier.Algo.ParcoursLargeur;
import grapheffect_ia.Metier.Carte.Coordonnee;
import grapheffect_ia.Metier.Vaisseaux.Vaisseau;

/**
 * Module en charge de la prise de décision
 * @author Matthieu
 */
public class Module_Decision extends Module {

    public Module_Decision(IA ia) {
        super(ia);
    }

    //Méthode principale de prise de décision
    public String determinerNouvelleAction(String messageRecu) {
        String reponse = "";
        Module_Memoire moduleMemoire = this.getIA().getModuleMemoire();
        if(!moduleMemoire.hasCarte()) {
            reponse = "CARTE";
        }
        else if(!moduleMemoire.hasBase()) {
            reponse = "BASE";
        }
        else if(moduleMemoire.getVaisseaux().isEmpty()) {
            reponse = "FABRIQUER|Explorateur";
            moduleMemoire.ajouterVaisseau();
        }
        else {
            Vaisseau vaisseau = moduleMemoire.getVaisseaux().get(0);
            if(vaisseau.getOrdre() != null){
                if(vaisseau.getPA() != 0) {
                    reponse = "MOUVEMENT|"+vaisseau.getNom()+"|"+vaisseau.getOrdre().name();
                    vaisseau.faireOrdre();
                    moduleMemoire.setCarteAJour(!vaisseau.besoinMiseAJourCarte());
                }
                else {
                    reponse = "FINTOUR";
                    for (Vaisseau v: this.getIA().getModuleMemoire().getVaisseaux()) {
                        v.resetPA();
                    }
                }
            }
            else if(!vaisseau.getPosition().equals(new Coordonnee(0,0))) {
                ParcoursLargeur parcours = new ParcoursLargeur(moduleMemoire.getCarte());
                parcours.calculer(moduleMemoire.getCarte().getCase(vaisseau.getPosition()));
                vaisseau.ajouterOrdres(parcours.getChemin(moduleMemoire.getCarte().getCase(new Coordonnee(0,0))));

                if(vaisseau.getPA() != 0) {
                    reponse = "MOUVEMENT|"+vaisseau.getNom()+"|"+vaisseau.getOrdre().name();
                    vaisseau.faireOrdre();
                    moduleMemoire.setCarteAJour(!vaisseau.besoinMiseAJourCarte());
                }
                else {
                    reponse = "FINTOUR";
                    for (Vaisseau v: this.getIA().getModuleMemoire().getVaisseaux()) {
                        v.resetPA();
                    }
                }
            }
            else {
                reponse = "FIN";
                this.getIA().arretDiscussion();
            }
        }
        return reponse;
    }
}
