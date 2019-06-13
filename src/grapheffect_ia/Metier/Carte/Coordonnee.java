package grapheffect_ia.Metier.Carte;

import java.util.Objects;

public class Coordonnee {
    private int ligne;
    private int colonne;

    public Coordonnee(int ligne, int colonne) {
        this.ligne = ligne;
        this.colonne = colonne;
    }

    public int getLigne() {
        return ligne;
    }

    public int getColonne() {
        return colonne;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordonnee that = (Coordonnee) o;
        return ligne == that.ligne &&
                colonne == that.colonne;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ligne, colonne);
    }

    public Coordonnee voisin(TypeMouvement mouvement) {
        Coordonnee c = null;
        if (this.colonne % 2 != 0) {
            switch (mouvement) {
                case Bas:
                    c = new Coordonnee(this.ligne + 1,this.colonne);
                    break;
                case Haut:
                    c = new Coordonnee(this.ligne - 1,this.colonne);;
                    break;
                case BasDroit:
                    c = new Coordonnee(this.ligne + 1,this.colonne + 1);
                    break;
                case BasGauche:
                    c = new Coordonnee(this.ligne + 1,this.colonne - 1);
                    break;
                case HautDroit:
                    c = new Coordonnee(this.ligne,this.colonne + 1);
                    break;
                case HautGauche:
                    c = new Coordonnee(this.ligne,this.colonne - 1);
                    break;
                default: c = new Coordonnee(this.ligne,this.colonne);
            }
        } else {
            switch (mouvement) {
                case Bas:
                    c = new Coordonnee(this.ligne + 1,this.colonne);
                    break;
                case Haut:
                    c = new Coordonnee(this.ligne - 1,this.colonne);
                    break;
                case BasDroit:
                    c = new Coordonnee(this.ligne,this.colonne + 1);
                    break;
                case BasGauche:
                    c = new Coordonnee(this.ligne,this.colonne - 1);
                    break;
                case HautDroit:
                    c = new Coordonnee(this.ligne - 1,this.colonne + 1);
                    break;
                case HautGauche:
                    c = new Coordonnee(this.ligne - 1,this.colonne - 1);
                    break;
                    default: c = new Coordonnee(this.ligne,this.colonne);
            }
        }
        return c;
    }

    public static Coordonnee fromString(String message) {
        String[] temp = message.split(",",2);
        int ligne = Integer.valueOf(temp[0]);
        int colonne = Integer.valueOf(temp[1]);
        return new Coordonnee(ligne,colonne);
    }

    @Override
    public String toString() {
        return "("+ligne+","+colonne+")";
    }
}
