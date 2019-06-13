/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grapheffect_ia.Metier.Carte;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author simonetma
 */
public class CoordonneeFromStringTest {
        
    @Test
    public void testFromString57() {
        System.out.println("Test de la méthode fromString pour (5,7)");
        String message = "5,7";        
        Coordonnee resCalcule = Coordonnee.fromString(message);
        Coordonnee resAttendu = new Coordonnee(5,7);
        assertEquals(resAttendu,resCalcule);
    }
    
    @Test
    public void testFromString62() {
        System.out.println("Test de la méthode fromString pour (6,2)");
        String message = "6,2";        
        Coordonnee resCalcule = Coordonnee.fromString(message);
        Coordonnee resAttendu = new Coordonnee(6,2);
        assertEquals(resAttendu,resCalcule);
    }
    
}
