package grapheffect_ia.Modules;

import grapheffect_ia.IA;

/**
 * Classe abstraite des différents modules de l'IA
 * @author Matthieu
 */
public abstract class Module {
    private IA ia;
    
    public Module(IA ia) {
        this.ia = ia;
    }
    
    public IA getIA() {
        return this.ia;
    }
    
}
