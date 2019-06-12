package grapheffect_ia.Metier.Carte.Cases;

import grapheffect_ia.Metier.Carte.Coordonnee;

public class Case_Planete extends Case {
    public Case_Planete(Coordonnee coordonnee) {
        super(coordonnee);
    }

    @Override
    public TypeCase getType() {
        return TypeCase.PLANETE;
    }

    @Override
    public boolean isAccessible() {
        return true;
    }
}
