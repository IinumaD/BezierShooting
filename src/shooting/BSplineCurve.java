/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shooting;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Iinuma
 */
public class BSplineCurve {
    private List<Double> knot = new ArrayList<>();
    private List<Point> controlPoints;
    private List<Point> evaluatedPoints = new ArrayList<>();
    private final int degree = 3; //次数
    private final int segment = 3; //セグメント数
    private final int m = 2*degree + (segment + 1); //ノット数
    
    public BSplineCurve(List<Point> controlPoints){
        this.controlPoints = controlPoints;
        for(Integer i = 0; i < m; i++){
            double t = i - degree;
            knot.add(t);
        }
    }
    
    public void evaluate(){
        if(!evaluatedPoints.isEmpty()){
            evaluatedPoints.clear();
        }
        
        for(double t = knot.get(degree); t < knot.get(controlPoints.size()); t += 0.01){
            spline(t);
        }
    }
    
    public void spline(double t){
        Double sum_x = 0.0, sum_y=0.0;
        for(int i = 0; i <= degree + segment -1; i++){
            sum_x += bsplineBasement(t, i, degree)*controlPoints.get(i).getX();
            sum_y += bsplineBasement(t, i, degree)*controlPoints.get(i).getY();
        }
        //System.out.println("( " + sum_x + " , " + sum_y + " ) ");
        evaluatedPoints.add(new Point(sum_x, sum_y));
    }
    
    private Double bsplineBasement(double t, int i, int n){
        if(n == 0){
            if(knot.get(i) <= t && t < knot.get(i+1)){
                return 1.0;
            }else{
                return 0.0;
            }
        }
        else{
            Double N_1 = ((t-knot.get(i)) / (knot.get(i+n)-knot.get(i)))*bsplineBasement(t, i, n-1);
            Double N_2 = ((knot.get(i+n+1)-t) / (knot.get(i+n+1)-knot.get(i+1)))*bsplineBasement(t, i+1, n-1);
            return N_1 + N_2;
        }
    }
    
    public List<Point> getEvaluatedPoints(){
        return this.evaluatedPoints;
    }
    
    public void clearEvaluatePoints(){
        this.evaluatedPoints.clear();
    }
}
