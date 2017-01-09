/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shooting;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Iinuma
 */
public class PointTest {
    
    public PointTest() {
    }

    /**
     * Test of getX method, of class Point.
     */
    @Test
    public void testGetX() {
        System.out.println("getX");
        Point instance = new Point(0.0,0.0);
        Double expResult = 0.0;
        Double result = instance.getX();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getY method, of class Point.
     */
    @Test
    public void testGetY() {
        System.out.println("getY");
        Point instance = new Point(0.0,2.0);
        Double expResult = 2.0;
        Double result = instance.getY();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of internalDiveide method, of class Point.
     */
    @Test
    public void testInternalDiveide() {
        System.out.println("internalDiveide");
        Point p1 = new Point(0.0, 0.0);
        Point p2 = new Point(1.0, 2.0);
        Double r1 = 1.0;
        Double r2 = 3.0;
        Point expResult = new Point(0.25, 0.5);
        Point result = Point.internalDiveide(p1, p2, r1, r2);
        assertEquals(expResult.getX(), result.getX(), 1.0e-10);
        assertEquals(expResult.getY(), result.getY(), 1.0e-10);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
