package grapheffect_ia.Metier.Carte;

import org.junit.Test;
import static org.junit.Assert.*;

public class CoordonneeTestVoisin {

    @Test
    public void testVoisinHaut33() {
        System.out.println("Voisin Haut de (3,3)");
        Coordonnee instance = new Coordonnee(3,3);
        TypeMouvement mouvement = TypeMouvement.Haut;;
        Coordonnee expResult = new Coordonnee(2,3);;
        Coordonnee result = instance.voisin(mouvement);
        assertEquals("Voisin Haut de la case (3,3)",expResult, result);
    }
    
    @Test
    public void testVoisinBas33() {
        System.out.println("Voisin Bas de (3,3)");
        Coordonnee instance = new Coordonnee(3,3);
        TypeMouvement mouvement = TypeMouvement.Bas;;
        Coordonnee expResult = new Coordonnee(4,3);
        Coordonnee result = instance.voisin(mouvement);
        assertEquals("Voisin Bas de la case (3,3)",expResult, result);
    }
    
    @Test
    public void testVoisinHautDroit33() {
        System.out.println("Voisin HautDroit de (3,3)");
        Coordonnee instance = new Coordonnee(3,3);
        TypeMouvement mouvement = TypeMouvement.HautDroit;
        Coordonnee expResult = new Coordonnee(3,4);
        Coordonnee result = instance.voisin(mouvement);
        assertEquals("Voisin HautDroit de la case (3,3)",expResult, result);
    }
    
    @Test
    public void testVoisinHautGauche33() {
        System.out.println("Voisin HautGauche de (3,3)");
        Coordonnee instance = new Coordonnee(3,3);
        TypeMouvement mouvement = TypeMouvement.HautGauche;
        Coordonnee expResult = new Coordonnee(3,2);
        Coordonnee result = instance.voisin(mouvement);
        assertEquals("Voisin HautGauche de la case (3,3)",expResult, result);
    }
    
    @Test
    public void testVoisinBasDroit33() {
        System.out.println("Voisin BasDroit de (3,3)");
        Coordonnee instance = new Coordonnee(3,3);
        TypeMouvement mouvement = TypeMouvement.BasDroit;
        Coordonnee expResult = new Coordonnee(4,4);
        Coordonnee result = instance.voisin(mouvement);
        assertEquals("Voisin BasDroit de la case (3,3)",expResult, result);   
    }
    
    @Test
    public void testVoisinBasGauche33() {
        System.out.println("Voisin BasGauche de (3,3)");
        Coordonnee instance = new Coordonnee(3,3);
        TypeMouvement mouvement = TypeMouvement.BasGauche;
        Coordonnee expResult = new Coordonnee(4,2);
        Coordonnee result = instance.voisin(mouvement);
        assertEquals("Voisin BasGauche de la case (3,3)",expResult, result);
    }    
        
     @Test
    public void testVoisinHaut64() {
        System.out.println("Voisin Haut de (6,4)");
        Coordonnee instance = new Coordonnee(6,4);
        TypeMouvement mouvement = TypeMouvement.Haut;;
        Coordonnee expResult = new Coordonnee(5,4);;
        Coordonnee result = instance.voisin(mouvement);
        assertEquals("Voisin Haut de la case (6,4)",expResult, result);
    }
    
    @Test
    public void testVoisinBas64() {
        System.out.println("Voisin Bas de (6,4)");
        Coordonnee instance = new Coordonnee(6,4);
        TypeMouvement mouvement = TypeMouvement.Bas;;
        Coordonnee expResult = new Coordonnee(7,4);
        Coordonnee result = instance.voisin(mouvement);
        assertEquals("Voisin Bas de la case (6,4)",expResult, result);
    }
    
    @Test
    public void testVoisinHautDroit64() {
        System.out.println("Voisin HautDroit de (6,4)");
        Coordonnee instance = new Coordonnee(6,4);
        TypeMouvement mouvement = TypeMouvement.HautDroit;
        Coordonnee expResult = new Coordonnee(5,5);
        Coordonnee result = instance.voisin(mouvement);
        assertEquals("Voisin HautDroit de la case (6,4)",expResult, result);
    }
    
    @Test
    public void testVoisinHautGauche64() {
        System.out.println("Voisin HautGauche de (6,4)");
        Coordonnee instance = new Coordonnee(6,4);
        TypeMouvement mouvement = TypeMouvement.HautGauche;
        Coordonnee expResult = new Coordonnee(5,3);
        Coordonnee result = instance.voisin(mouvement);
        assertEquals("Voisin HautGauche de la case (6,4)",expResult, result);
    }
    
    @Test
    public void testVoisinBasDroit64() {
        System.out.println("Voisin BasDroit de (6,4)");
        Coordonnee instance = new Coordonnee(6,4);
        TypeMouvement mouvement = TypeMouvement.BasDroit;
        Coordonnee expResult = new Coordonnee(6,5);
        Coordonnee result = instance.voisin(mouvement);
        assertEquals("Voisin BasDroit de la case (6,4)",expResult, result);   
    }
    
    @Test
    public void testVoisinBasGauche64() {
        System.out.println("Voisin BasGauche de (6,4)");
        Coordonnee instance = new Coordonnee(6,4);
        TypeMouvement mouvement = TypeMouvement.BasGauche;
        Coordonnee expResult = new Coordonnee(6,3);
        Coordonnee result = instance.voisin(mouvement);
        assertEquals("Voisin BasGauche de la case (6,4)",expResult, result);
    }    
      
    
}
