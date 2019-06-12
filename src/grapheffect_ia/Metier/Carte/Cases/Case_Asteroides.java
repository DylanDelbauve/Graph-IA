package grapheffect_ia.Metier.Carte.Cases;

import grapheffect_ia.Metier.Carte.Coordonnee;

public class Case_Asteroides extends Case {
    public Case_Asteroides(Coordonnee coordonnee) {
        super(coordonnee);
    }

    @Override
    public TypeCase getType() {
        return TypeCase.ASTEROIDES;
    }

    @Override
    public boolean isAccessible() {
        return false;
    }
}
