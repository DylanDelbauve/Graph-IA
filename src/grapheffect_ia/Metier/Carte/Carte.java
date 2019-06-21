package grapheffect_ia.Metier.Carte;

import grapheffect_ia.Metier.Carte.Cases.Case;
import grapheffect_ia.Metier.Carte.Cases.FabriqueCase;

import java.util.Collection;
import java.util.HashMap;

/**
 *
 * @author delbauve
 */
public class Carte {

    private HashMap<Coordonnee,Case> cases; //liste des cases par rapport à leurs coordonnées

    /**
     * Créer une carte en fonction du message
     * @param messageRecu le message reçu par L'IA
     */
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

    /**
     * Ajoute une case à la carte
     * @param coordonnee les coordonnées de la case
     * @param lettre le type de la case
     */
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

    /**
     * Renvoie la case en fonction des coordonnées
     * @param coordonnee coordonnée de la case
     * @return la case
     */
    public Case getCase(Coordonnee coordonnee) {
        return cases.get(coordonnee);
    }

    /**
     * Renvoie une liste de toutes les cases
     * @return une liste de cases
     */
    public Collection<Case> getCases() {
        return cases.values();
    }
}
