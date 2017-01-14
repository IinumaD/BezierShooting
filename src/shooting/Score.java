/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shooting;

import java.util.List;

/**
 *
 * @author Iinuma
 */
public class Score {
    
    public static Integer caluclate(List<Point> curve, Point p, int radius){
        Integer score = 0;
        for(int i = 0; i < curve.size(); i++){
            double diff = (double)radius - distance(curve.get(i), p);
            if(0 <= diff){
                score += (int)(diff*5*0.1);
            }
        }
        return score;
    }
    
    public static double distance(Point p1, Point p2){
        return Math.sqrt(Math.pow(p2.getX()-p1.getX(), 2) + Math.pow(p2.getY()-p1.getY(), 2));
    }
    
}
