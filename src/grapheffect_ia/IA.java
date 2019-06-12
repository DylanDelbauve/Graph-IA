package grapheffect_ia;

import grapheffect_ia.Modules.Module_Communication;
import grapheffect_ia.Modules.Module_Decision;
import grapheffect_ia.Modules.Module_Memoire;
import grapheffect_ia.Modules.Module_Reaction;
import java.io.IOException;

/**
 * Classe principale de l'IA
 * @author Matthieu
 */
public class IA {


    private Module_Communication moduleCommunication;                           //Module de communication avec le serveur
    private Module_Decision moduleDecision;                                     //Module en charge de la prise de décisions
    private Module_Memoire moduleMemoire;                                       //Module en charge de la mémorisation des informations
    private Module_Reaction moduleReaction;                                     //Module en charge de la réaction de l'IA à un message du serveur
    private boolean isDiscussionTerminee;                                       //La discussion avec le serveur est-elle terminée
    private String messageEnvoye;                                               //Dernier message envoyé au serveur (ou devant être envoyé)
    private String messageRecu;                                                 //Dernier message reçu du serveur
    
    //Constructeur de l'IA
    public IA() {
        this.messageEnvoye = "";
        this.messageRecu = "";
        this.initialisation_Modules();
    }
    
    //Initialise les différents modules de l'IA
    private void initialisation_Modules() {
        //Module de communication avec le serveur
        this.moduleCommunication = new Module_Communication(this);
        //Module de prise de décision
        this.moduleDecision = new Module_Decision(this);
        //Module de gestion de la mémoire
        this.moduleMemoire = new Module_Memoire(this);
        //Module de réaction aux messages du serveur
        this.moduleReaction = new Module_Reaction(this);
    }
    
    //Getter des différents modules
    public Module_Communication getModuleCommunication() {
        return this.moduleCommunication; 
    }
    public Module_Decision getModuleDecision() {
        return this.moduleDecision;
    }
    public Module_Memoire getModuleMemoire() {
        return this.moduleMemoire;
    }
    public Module_Reaction getModuleReaction() {
        return this.moduleReaction;
    }
    
    //Fonction servant à démarrer l'IA
    public void start() throws IOException {
        //LANCEMENT DU MODULE DE COMMUNICATION
            //Connexion au serveur
        this.moduleCommunication.connexion();   
            //Création des gestoionnaires des flux de communication
        this.moduleCommunication.creationFlux();                                
        
        //LANCEMENT DE LA BOUCLE DE DISCUSSION
        this.isDiscussionTerminee = false;
        while(!isDiscussionTerminee) {
            //Recepetion d'un message du serveur
            messageRecu = this.moduleCommunication.recevoirMessage();
            //On traite ce message
            this.reagirAuMessageRecu();
            //On détermine quoi faire
            messageEnvoye = this.determinerNouvelleAction();
            //On encoit le message au serveur
            this.moduleCommunication.envoyerMessage(messageEnvoye);
            
        }
    }
    
    
    //Interpréter la réponse du serveur et la prendre en compte
    private void reagirAuMessageRecu() {
        this.moduleReaction.reagirAuMessageRecu(messageEnvoye,messageRecu);
    }
    
    //Déterminer la prochaine action à faire
    private String determinerNouvelleAction() {
        return this.moduleDecision.determinerNouvelleAction(messageRecu);
    }
    
    //Met un terme à la discussion après le prochain message envoyé
    public void arretDiscussion() {
        this.isDiscussionTerminee = true;
    }
}
