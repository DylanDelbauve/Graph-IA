package grapheffect_ia.Metier.Carte.Cases;

import grapheffect_ia.Metier.Carte.Coordonnee;

public class Case_Espace extends Case {
    public Case_Espace(Coordonnee coordonnee) {
        super(coordonnee);
    }

    @Override
    public TypeCase getType() {
        return TypeCase.ESPACE;
    }

    @Override
    public boolean isAccessible() {
        return true;
    }
}
