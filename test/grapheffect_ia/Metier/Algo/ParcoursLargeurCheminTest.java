/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grapheffect_ia.Metier.Algo;

import grapheffect_ia.Metier.Carte.Carte;
import grapheffect_ia.Metier.Carte.Cases.Case;
import grapheffect_ia.Metier.Carte.Coordonnee;
import grapheffect_ia.Metier.Carte.TypeMouvement;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author simonetma
 */
public class ParcoursLargeurCheminTest {
    
    //CE TEST SUPPOSE QUE LES CLASSES CARTE ET COORDONNEES SONT FONCTIONNELLES !
    
    private Carte carteTest;
    private ParcoursLargeur instance;
    private Case depart;
    
    public ParcoursLargeurCheminTest() {
    }
    
    @Before
    public void setUp() {
        //Création de la carte de test et de la case de départ
        String messageServeur = "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXEEEXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXAEEEEEEXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXAEEEEEEXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXAEEEEEEXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXEEEEEEEXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXEEEEEXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXEXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX";
        this.carteTest = new Carte(messageServeur);
        this.depart = this.carteTest.getCase(new Coordonnee(8,20));
        //Création de l'instance de l'algo à tester
        this.instance = new ParcoursLargeur(this.carteTest);
        //Lancement des calculs
        this.instance.calculer(depart);
    }
    

    @Test
    public void testGetCheminVersVoisin() {
        System.out.println("Test pour les 6 cases voisines de la base");
        Case arrivee = this.carteTest.getCase(new Coordonnee(7,20));
        ArrayList<TypeMouvement> cheminAttendu = new ArrayList<TypeMouvement>(Arrays.asList(TypeMouvement.Haut));
        assertEquals(cheminAttendu,this.instance.getChemin(arrivee));
        
        arrivee = this.carteTest.getCase(new Coordonnee(7,21));
        cheminAttendu = new ArrayList<TypeMouvement>(Arrays.asList(TypeMouvement.HautDroit));
        assertEquals(cheminAttendu,this.instance.getChemin(arrivee));
        
        arrivee = this.carteTest.getCase(new Coordonnee(8,21));
        cheminAttendu = new ArrayList<TypeMouvement>(Arrays.asList(TypeMouvement.BasDroit));
        assertEquals(cheminAttendu,this.instance.getChemin(arrivee));
        
        arrivee = this.carteTest.getCase(new Coordonnee(9,20));
        cheminAttendu = new ArrayList<TypeMouvement>(Arrays.asList(TypeMouvement.Bas));
        assertEquals(cheminAttendu,this.instance.getChemin(arrivee));
        
        arrivee = this.carteTest.getCase(new Coordonnee(8,19));
        cheminAttendu = new ArrayList<TypeMouvement>(Arrays.asList(TypeMouvement.BasGauche));
        assertEquals(cheminAttendu,this.instance.getChemin(arrivee));
        
        arrivee = this.carteTest.getCase(new Coordonnee(7,19));
        cheminAttendu = new ArrayList<TypeMouvement>(Arrays.asList(TypeMouvement.HautGauche));
        assertEquals(cheminAttendu,this.instance.getChemin(arrivee));
    }
    
    @Test
    public void testGetCheminDerriereAsteroidesBas() {
        System.out.println("Test pour se rendre à la case (8,16) derrière les astéroides");
        Case arrivee = this.carteTest.getCase(new Coordonnee(8,16));
        ArrayList<TypeMouvement> cheminAttendu = new ArrayList<TypeMouvement>(Arrays.asList(TypeMouvement.BasGauche,TypeMouvement.BasGauche,TypeMouvement.BasGauche,TypeMouvement.HautGauche,TypeMouvement.Haut));
        assertEquals(cheminAttendu,this.instance.getChemin(arrivee));
    }
    
    @Test
    public void testGetCheminSurAsteroides() {
        System.out.println("Test pour se rendre à la case (8,17) ce qui n'est pas possible");
        Case arrivee = this.carteTest.getCase(new Coordonnee(8,17));
        ArrayList<TypeMouvement> cheminAttendu = new ArrayList<TypeMouvement>(Arrays.asList());
        assertEquals(cheminAttendu,this.instance.getChemin(arrivee));
    }
}
