package grapheffect_ia.Metier.Carte.Cases;

/**
 * type de case
 * @author delbauve
 */
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
