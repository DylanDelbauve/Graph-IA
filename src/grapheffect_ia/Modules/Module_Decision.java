package grapheffect_ia.Modules;

import grapheffect_ia.IA;
import grapheffect_ia.Metier.Algo.ParcoursLargeur;
import grapheffect_ia.Metier.Carte.Coordonnee;
import grapheffect_ia.Metier.Vaisseaux.Vaisseau;
import grapheffect_ia.Modules.AutomateModuleDecision.Etat;
import grapheffect_ia.Modules.AutomateModuleDecision.Etat_Initial;

/**
 * Module en charge de la prise de décision
 * @author Matthieu
 */
public class Module_Decision extends Module {
    Etat etatCourant = new Etat_Initial(this);

    public Module_Decision(IA ia) {
        super(ia);
    }

    //Méthode principale de prise de décision
    public String determinerNouvelleAction(String messageRecu) {
        String reponse = "";
        while (reponse == "") {
            etatCourant = etatCourant.transition();
            reponse = etatCourant.messageAEnvoyer();
        }
        return reponse;
    }
}
