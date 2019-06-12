package grapheffect_ia.Metier.Carte.Cases;

import grapheffect_ia.Metier.Carte.Coordonnee;

public class Case_Etoile extends Case {
    public Case_Etoile(Coordonnee coordonnee) {
        super(coordonnee);
    }

    @Override
    public TypeCase getType() {
        return TypeCase.ETOILE;
    }

    @Override
    public boolean isAccessible() {
        return false;
    }
}
