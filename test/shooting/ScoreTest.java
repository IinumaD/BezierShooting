/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shooting;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Iinuma
 */
public class ScoreTest {
    
    public ScoreTest() {
    }

    /**
     * Test of caluclate method, of class Score.
     */
    @Test
    public void testCaluclate() {
        System.out.println("caluclate");
        List<Point> curve = new ArrayList<>(Arrays.asList(new Point(0.0, 0.0), new Point(0.5, 1.0), new Point(1.0, 1.0)));
        Point p = new Point(0.5, 0.5);
        int radius = 10;
        Integer expResult = 10*3;
        Integer result = Score.caluclate(curve, p, radius);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of distance method, of class Score.
     */
    @Test
    public void testDistance() {
        System.out.println("distance");
        Point p1 = new Point(0.0, 1.0);
        Point p2 = new Point(1.0, 2.0);
        double expResult = Math.sqrt(2.0);
        double result = Score.distance(p1, p2);
        assertEquals(expResult, result, 1.0e-10);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
