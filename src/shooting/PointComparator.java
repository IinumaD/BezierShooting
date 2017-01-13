/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shooting;
import java.util.Comparator;

/**
 *
 * @author Iinuma
 */
public class PointComparator{
    
    public int compare(Point p1, Point p2){
        double x1 = p1.getX();
        double x2 = p2.getX();
        
        if(x1 > x2){
            return 1;
        }else if(x1 == x2){
            return 0;
        }else{
            return -1;
        }
    }
}
