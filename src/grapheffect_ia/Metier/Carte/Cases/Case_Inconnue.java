package grapheffect_ia.Metier.Carte.Cases;

import grapheffect_ia.Metier.Carte.Coordonnee;

public class Case_Inconnue extends Case {
    public Case_Inconnue(Coordonnee coordonnee) {
        super(coordonnee);
    }

    @Override
    public TypeCase getType() {
        return TypeCase.INCONNUE;
    }

    @Override
    public boolean isAccessible() {
        return true;
    }
}
