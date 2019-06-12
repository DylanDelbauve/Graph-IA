package grapheffect_ia.Modules;

import grapheffect_ia.IA;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Module en charge de la communication avec le serveur
 * @author Matthieu
 */
public class Module_Communication extends Module {

    private Socket socket;
    private BufferedReader fluxEntrant;
    private PrintWriter fluxSortant;
    
    public Module_Communication(IA ia) {
        super(ia);
    }
    
    //Connecte le client au serveur
    public void connexion() throws IOException {
        //Création du socket entre client et serveur
        this.socket = new Socket("127.0.0.1",1234);
    }
    
    //Crée les deux gestionnaires de flux
    public void creationFlux() throws IOException {
        //Création du gestionnaire de flux entrant
        InputStreamReader iSReader = new InputStreamReader(this.socket.getInputStream());
        this.fluxEntrant = new BufferedReader(iSReader);
        //Création du gestionnaire de flux sortant
        this.fluxSortant = new PrintWriter(this.socket.getOutputStream(),true);
    }

    //Envoie le message donné au serveur
    public void envoyerMessage(String message) {
        System.out.println(">>"+message);
        this.fluxSortant.println(message);
    }
    
    //Ecoute et renvoie un message du serveur
    public String recevoirMessage() throws IOException {
        String message = this.fluxEntrant.readLine();
        System.out.println("<<"+message);
        return message;
    }
    
}
