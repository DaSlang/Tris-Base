package test.it.unibas.modello;

import it.unibas.trisbase.Costanti;
import it.unibas.trisbase.modello.Griglia;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestGriglia {   
    
    @Test
    public void testGrigliaNonPiena() {
        Griglia griglia = new Griglia(3);
        assertFalse("Test griglia non piena", griglia.isPiena());
    }

    @Test
    public void testGrigliaPiena() {
        Griglia griglia = new Griglia(5);
        for (int i = 0; i < griglia.getDimensione(); i++) {
            for (int j = 0; j < griglia.getDimensione(); j++) {
                griglia.setStatoCella(i, j, Costanti.STATO_X);
            }
        }
        assertTrue("Test griglia piena", griglia.isPiena());
    }

    @Test
    public void testTrisRigaUno() {
        Griglia griglia = new Griglia(3);
        griglia.setStatoCella(0, 0, Costanti.STATO_X);
        griglia.setStatoCella(0, 1, Costanti.STATO_X);
        griglia.setStatoCella(0, 2, Costanti.STATO_X);
        assertTrue("Test tris riga uno", griglia.controllaTris());
    }
    
    @Test
    public void testNoTrisRigaUno() {
        Griglia griglia = new Griglia(3);
        griglia.setStatoCella(0, 0, Costanti.STATO_X);
        griglia.setStatoCella(0, 1, Costanti.STATO_X);
        griglia.setStatoCella(0, 2, Costanti.STATO_O);
        assertTrue("Test no tris riga uno", !griglia.controllaTris());
    }

    @Test
    public void testTrisColonnaUno() {
        Griglia griglia = new Griglia(3);
        griglia.setStatoCella(0, 1, Costanti.STATO_X);
        griglia.setStatoCella(1, 1, Costanti.STATO_X);
        griglia.setStatoCella(2, 1, Costanti.STATO_X);
        assertTrue("Test tris riga uno", griglia.controllaTris());
    }
    
    @Test
    public void testSuperTrisColonnaUno() {
        Griglia griglia = new Griglia(6);
        griglia.setStatoCella(0, 1, Costanti.STATO_X);
        griglia.setStatoCella(1, 1, Costanti.STATO_X);
        griglia.setStatoCella(2, 1, Costanti.STATO_X);
        griglia.setStatoCella(3, 1, Costanti.STATO_X);
        griglia.setStatoCella(4, 1, Costanti.STATO_X);
        griglia.setStatoCella(5, 1, Costanti.STATO_X);
        assertTrue("Test tris riga uno", griglia.controllaTris());
    }

    @Test
    public void testTrisDiagonalePrincipale() {
        Griglia griglia = new Griglia(3);
        griglia.setStatoCella(0, 0, Costanti.STATO_X);
        griglia.setStatoCella(1, 1, Costanti.STATO_X);
        griglia.setStatoCella(2, 2, Costanti.STATO_X);
        assertTrue("Test tris riga uno", griglia.controllaTris());
    }
    
    @Test
    public void testTrisDiagonaleSecondaria() {
        Griglia griglia = new Griglia(3);
        griglia.setStatoCella(0, 2, Costanti.STATO_X);
        griglia.setStatoCella(1, 1, Costanti.STATO_X);
        griglia.setStatoCella(2, 0, Costanti.STATO_X);
        assertTrue("Test tris riga uno", griglia.controllaTris());
    }
    
}
