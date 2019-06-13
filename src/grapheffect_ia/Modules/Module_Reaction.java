package grapheffect_ia.Modules;

import grapheffect_ia.IA;
import grapheffect_ia.Metier.Vaisseaux.Vaisseau;

/**
 * Module en charge de la réaction de l'IA à un message du serveur
 * @author Matthieu
 */
public class Module_Reaction extends Module {

    public Module_Reaction(IA ia) {
        super(ia);
    }
    
    //Méthode principale de réaction à un message reçu
    public void reagirAuMessageRecu(String messageEnvoye, String
            messageRecu) {
        switch(messageEnvoye) {
            case "CARTE" : reactionCarte(messageRecu);
                break;
            case "BASE" : reactionBase(messageRecu);
                break;
            case "FINTOUR" : reactionFinTour(messageRecu);
        }
    }

    public void reactionCarte(String messageRecu) {
        this.getIA().getModuleMemoire().genererCarte(messageRecu) ;
    }

    public void reactionBase(String messageRecu) {
        this.getIA().getModuleMemoire().setBase(messageRecu);
    }

    private void reactionFinTour(String messageRecu) {
        if (messageRecu == "FINTOUR") {
            for (Vaisseau v: this.getIA().getModuleMemoire().getVaisseaux()) {
                v.resetPA();
            }
        }
    }

}
