package grapheffect_ia.Metier.Carte;

import grapheffect_ia.Metier.Carte.Cases.Case;
import grapheffect_ia.Metier.Carte.Cases.FabriqueCase;

import java.util.HashMap;

public class Carte {

    private HashMap<Coordonnee,Case> cases;

    public Carte(String messageRecu) {
        this.cases = new HashMap<>() ;
        for(int i=0 ;i<41 ;i++) {
            for(int j=0 ;j<55 ;j++) {
                this.ajouterCase(new Coordonnee(i,j), messageRecu
                        .charAt(j+55*i)) ;
            }
        }
        for(int i=0 ;i<41 ;i++) {
            for(int j=0 ;j<55 ;j++) {
                Coordonnee cooCase = new Coordonnee(i,j) ;
                for(TypeMouvement mouvement : TypeMouvement.values()) {
                    Coordonnee cooVoisin = cooCase.voisin(mouvement) ;
                    if(this.cases.get(cooVoisin) != null) {
                        this.cases.get(cooCase).ajouterVoisin(this.cases.get(
                                cooVoisin)) ;
                    }
                }
            }
        }
    }

    private void ajouterCase(Coordonnee coordonnee, Character lettre) {
        Case c = FabriqueCase.Creer(coordonnee,lettre);
        cases.put(c.getCoordonnee(),c);
    }

    public void afficheConsole() {
        for(int i=0 ;i<41 ;i++) {
            for(int j=0 ;j<55 ;j++) {
                switch(this.cases.get(new Coordonnee(i,j)).getType()) {
                    case INCONNUE: System.out.print("X") ; break ;
                    case ESPACE: System.out.print("E") ; break ;
                    case ASTEROIDES: System.out.print("A") ; break ;
                    case PLANETE: System.out.print("P") ; break ;
                    case ETOILE: System.out.print("S") ; break ;
                }
            }
            System.out.println("") ;
        }
    }

    public Case getCase(Coordonnee coordonnee) {
        return cases.get(coordonnee);
    }
}
