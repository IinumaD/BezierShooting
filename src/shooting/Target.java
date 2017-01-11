/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shooting;
import java.util.List;
import java.util.ArrayList;
import java.lang.Math;
import java.util.Random;

/**
 *
 * @author Iinuma
 */
public class Target {
    private List<Point> targets = new ArrayList<>();
    private final Integer radius = 10;
    private final Double start;
    private final Double goal;
    private Random random;
    private Double maxX;
    private Double maxY;
    private Double limitY;
    
    public Target(double screenWidth, double screenHeight){
        random = new Random();
        start = screenWidth / 6;
        goal = screenWidth - (screenWidth / 6);
        this.maxX = screenWidth;
        this.maxY = screenHeight;
        this.limitY = screenHeight / 6;
    }
    
    public Point createFirstPoint(){
        double x = random.nextDouble()*start;
        double y = (random.nextDouble()*(maxY-limitY))+limitY;
        
        return new Point(x, y);
    }
    
    public Point createLastPoint(){
        double x = (random.nextDouble()*(maxX-goal))+goal;
        double y = (random.nextDouble()*(maxY-limitY))+limitY;

        return new Point(x,y);
    }
    
    public int getRadius(){
        return this.radius;
    }
    
}
