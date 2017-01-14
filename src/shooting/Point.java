/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shooting;

/**
 *
 * @author Iinuma
 */
public class Point {
    private final Double x;
    private final Double y;
    
    /**
     * コンストラクタ
     * 指定した座標にある点を生成する.
     * @param x
     * @param y 
     */
    public Point(Double x, Double y){
        this.x = x;
        this.y = y;
    }
    
    public Double getX(){
        return this.x;
    }
    
    public Double getY(){
        return this.y;
    }
    
    /**
     * 点p1と点p2をr1:r2で内聞する点を計算する.
     * @param p1 : 1つ目の点
     * @param p2 : 2つ目の点
     * @param r1 : 内分比
     * @param r2 : 内分比
     * @return 点p1と点p2をr1:r2で内分する点
     * 
     */
    public static Point internalDiveide(Point p1, Point p2, Double r1, Double r2){
        Double divX = (r2*p1.getX() + r1*p2.getX()) / (r1+r2);
        Double divY = (r2*p1.getY() + r1*p2.getY()) / (r1+r2);
        
        return new Point(divX, divY);
    }
}
