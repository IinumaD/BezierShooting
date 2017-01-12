/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shooting;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Iinuma
 */
public class BezierCurve {
    private List<Point> controlPoints = new ArrayList<>();
    private List<Point> evaluatedPoints = new ArrayList<>();
    private Integer grade;
    
    public BezierCurve(List<Point> controlPoints){
        this.grade = controlPoints.size()-1;
        this.controlPoints = controlPoints;
    }
    
    public void evaluate(){
        if(!this.evaluatedPoints.isEmpty()){
            clearEvaluatedPoints();
        }
        
        for(double t = 0; t < 1; t += 0.001){
            evaluatedPoints.add(deCasteljau(t));
        }
    }
    
    private Point deCasteljau(double t){
        List<List<Point>> EP = new ArrayList<>();
        EP.add(this.controlPoints);
        for(int i = 1; i < grade+1; i++){
            List<Point> L = new ArrayList<>();
            for(int j = 0; j < grade+1 - i; j++){
                double x = (1-t)*EP.get(i-1).get(j).getX() + t *EP.get(i-1).get(j+1).getX();
                double y = (1-t)*EP.get(i-1).get(j).getY() + t *EP.get(i-1).get(j+1).getY();

                L.add(new Point(x,y));
            }
            EP.add(L);
        }
        return new Point(EP.get(grade).get(0).getX(), EP.get(grade).get(0).getY());
    }
    
    public void clearEvaluatedPoints(){
        evaluatedPoints.clear();
    }
    
    public void setControlPoints(List<Point> newPoints){
        this.controlPoints = newPoints;
        this.grade = newPoints.size()-1;
    }
    
    public List<Point> getControlPoint(){
        return this.controlPoints;
    }
    
    public List<Point> getEvaluatedPoints(){
        return this.evaluatedPoints;
    }
}
