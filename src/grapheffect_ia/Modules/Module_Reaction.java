package grapheffect_ia.Modules;

import grapheffect_ia.IA;

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
            case "CARTE" : reactionCarte(messageRecu) ;
                break ;
        }
    }

    public void reactionCarte(String messageRecu) {
        this.getIA().getModuleMemoire().genererCarte(messageRecu) ;
    }

}
