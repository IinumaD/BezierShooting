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
    private BezierCurve answer;
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
    
    public int createDegree(){
        int degree = random.nextInt(5)+3;
        return degree;
    }
    
    public List<Point> createNormalPoints(){
        List<Point> points = new ArrayList<>();
        for(int i = 0; i < createDegree() - 2; i++){
            double x = (random.nextDouble()*(goal - start))+start;
            double y = (random.nextDouble()*(maxY-limitY))+limitY;
            points.add(new Point(x,y));
        }
        
        return points;
    }
    
    public void create(){
        List<Point> target = new ArrayList<>();
        target.add(createFirstPoint());
        target.addAll(createNormalPoints());
        target.add(createLastPoint());
        
        answer = new BezierCurve(target);
        answer.evaluate();
    }
    
    public List<Integer> selectTarget(){
        List<Integer> selectedIdx = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            Integer sel = random.nextInt(answer.getEvaluatedPoints().size());
            if(selectedIdx.contains(sel) ||
                    sel == 0 ||
                    sel == answer.getEvaluatedPoints().size()-1){
                i--;
                continue;
            }else{
                selectedIdx.add(sel);
            }
        }  
        return selectedIdx;
    }
    
    public List<Point> getTargets(){
        create();
        selectTarget().forEach(idx->targets.add(answer.getEvaluatedPoints().get(idx)));
        return targets;
    }
    
    public Point getFirstPoint(){
        return this.answer.getControlPoint().get(0);
    }
    
    public Point getLastPoint(){
        List<Point> list = this.answer.getControlPoint();
        return list.get(list.size()-1);
    }
    
    public List<Point> getAnswerCurve(){
        return this.answer.getEvaluatedPoints();
    }
    
    public int getRadius(){
        return this.radius;
    }
    
}
