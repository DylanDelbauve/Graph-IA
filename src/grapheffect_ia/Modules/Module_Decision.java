package grapheffect_ia.Modules;

import grapheffect_ia.IA;

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
        String s = "";
        if (!this.getIA().getModuleMemoire().hasCarte())
            s = "CARTE";
        else {
            this.getIA().arretDiscussion();
            s = "FIN";
        }
        return s;
    }
}
