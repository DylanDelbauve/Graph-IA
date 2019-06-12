/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grapheffect_ia.Metier.Algo;

import grapheffect_ia.Metier.Carte.Carte;
import grapheffect_ia.Metier.Carte.Coordonnee;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test de l'algo de calcul de distance
 * @author simonetma
 */
public class ParcoursLargeurCalculTest {
    
    //CE TEST SUPPOSE QUE LA CLASSE CARTE EST FONCTIONNELLE !
    
    private Carte carteTest;
    private ParcoursLargeur instance;
    
    public ParcoursLargeurCalculTest() {
    }
    
    @Before
    public void setUp() {
        //Création de la carte de test
        String messageServeur = "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXEEEXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXAEEEEEEXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXAEEEEEEXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXAEEEEEEXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXEEEEEEEXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXEEEEEXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXEXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX";
        this.carteTest = new Carte(messageServeur);
        //Création de l'instance de l'algo à tester
        this.instance = new ParcoursLargeur(this.carteTest);
        //Lancement des calculs
        this.instance.calculer(this.carteTest.getCase(new Coordonnee(8,20)));
    }

    /**
     * Test des calculs sur différents cas
     */
    @Test
    public void testCalculerVoisinsImmediats() {
        System.out.println("Test pour les voisins immédiats de la base (8,20)");
        int resCalcule = this.instance.getDistance(this.carteTest.getCase(new Coordonnee(7,20)));
        int resAttendu = 1;
        assertEquals(resAttendu,resCalcule);
        
        resCalcule = this.instance.getDistance(this.carteTest.getCase(new Coordonnee(7,21)));
        resAttendu = 1;
        assertEquals(resAttendu,resCalcule);
        
        resCalcule = this.instance.getDistance(this.carteTest.getCase(new Coordonnee(8,21)));
        resAttendu = 1;
        assertEquals(resAttendu,resCalcule);
        
        resCalcule = this.instance.getDistance(this.carteTest.getCase(new Coordonnee(9,20)));
        resAttendu = 1;
        assertEquals(resAttendu,resCalcule);
        
        resCalcule = this.instance.getDistance(this.carteTest.getCase(new Coordonnee(8,19)));
        resAttendu = 1;
        assertEquals(resAttendu,resCalcule);
        
        resCalcule = this.instance.getDistance(this.carteTest.getCase(new Coordonnee(7,19)));
        resAttendu = 1;
        assertEquals(resAttendu,resCalcule);
    }
    
    @Test
    public void testCalculerTrajetDegage() {
        System.out.println("Test pour les cases (8,18) et (7,22) à distance 2 - cas dégagé");
        int resCalcule = this.instance.getDistance(this.carteTest.getCase(new Coordonnee(7,22)));
        int resAttendu = 2;
        assertEquals(resAttendu,resCalcule);
        
        resCalcule = this.instance.getDistance(this.carteTest.getCase(new Coordonnee(8,18)));
        resAttendu = 2;
        assertEquals(resAttendu,resCalcule);
    }

    @Test
    public void testCalculerTrajetAsteroides() {
        System.out.println("Test pour les cases (8,17) et (7,17) à distance -1 - astéroides");
        int resCalcule = this.instance.getDistance(this.carteTest.getCase(new Coordonnee(8,17)));
        int resAttendu = -1;
        assertEquals(resAttendu,resCalcule);
        
        resCalcule = this.instance.getDistance(this.carteTest.getCase(new Coordonnee(7,17)));
        resAttendu = -1;
        assertEquals(resAttendu,resCalcule);
    }

    @Test
    public void testCalculerTrajetApresAsteroides() {
        System.out.println("Test pour les cases (8,16) et (7,16) - derrière des astéroides");
        int resCalcule = this.instance.getDistance(this.carteTest.getCase(new Coordonnee(8,16)));
        int resAttendu = 5;
        assertEquals(resAttendu,resCalcule);
        
        resCalcule = this.instance.getDistance(this.carteTest.getCase(new Coordonnee(7,16)));
        resAttendu = 6;
        assertEquals(resAttendu,resCalcule);
    }
    
}
