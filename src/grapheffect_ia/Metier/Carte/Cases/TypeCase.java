package grapheffect_ia.Metier.Carte.Cases;

public enum TypeCase {
    ASTEROIDES ("Asteroides"),
    ESPACE ("Espace"),
    ETOILE ("Etoile"),
    INCONNUE ("Inconnue"),
    PLANETE ("Planete");

    private String typeCase;

    TypeCase(String typecase) {
        this.typeCase = typecase;
    }
}
