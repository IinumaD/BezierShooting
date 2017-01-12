/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shooting;

import javafx.application.Application;
import javafx.scene.input.MouseEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.canvas.Canvas;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Iinuma
 */
public class Shooting extends Application {
    private final Canvas canvas = new Canvas(640,480);
    private final List<Point> inputPoints = new ArrayList<>();
    private BezierCurve bezier;
    private Target target;
    
    @Override
    public void start(Stage primaryStage) {
        
        canvas.setOnMouseClicked(this::drawPoint);
        Button clearBtn = new Button("Clear");
        clearBtn.setOnMouseClicked((MouseEvent e) -> {
            clearScreen();
        });
        Button lineBtn = new Button("Line");
        lineBtn.setOnMouseClicked((MouseEvent e)->{
            for(int i = 0; i < inputPoints.size()-1;i++){
                drawLine(inputPoints.get(i), inputPoints.get(i+1));
            }
        });
        Button bezierBtn = new Button("Bezier");
        bezierBtn.setOnMouseClicked((MouseEvent e)->{
            bezier = new BezierCurve(inputPoints);
            bezier.evaluate();
            List<Point> ep = bezier.getEvaluatedPoints();
            for(int i = 0; i < ep.size()-1; i++){
                drawLine(ep.get(i), ep.get(i+1));
            }
        });
        Button targetBtn = new Button("Target");
        targetBtn.setOnMouseClicked((MouseEvent e)->{
            target = new Target(canvas.getWidth(), canvas.getHeight());
            target.getTargets().forEach(list->drawPoint(list, 7));
            drawPoint(target.getFirstPoint(), 15);
            drawPoint(target.getLastPoint(), 15);
        });
        Button answerBtn = new Button("Answer");
        answerBtn.setOnMouseClicked((MouseEvent e)->{
            List<Point> ans = target.getAnswerCurve();
            for(int i = 0; i < ans.size()-1;i++){
                drawLine(ans.get(i), ans.get(i+1));
            }
        });
        
        Pane pane = new Pane(canvas);
        pane.getChildren().add(clearBtn);
        pane.getChildren().add(lineBtn);
        pane.getChildren().add(bezierBtn);
        pane.getChildren().add(targetBtn);
        pane.getChildren().add(answerBtn);
        Scene scene = new Scene(pane);
        
        clearBtn.relocate(0, 0);
        lineBtn.relocate(50, 0);
        bezierBtn.relocate(100, 0);
        targetBtn.relocate(150, 0);
        answerBtn.relocate(200, 0);
        

        primaryStage.setTitle("Bezier Shooting");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public void drawPoint(MouseEvent e){
        int r = 5;
        canvas.getGraphicsContext2D()
                .strokeOval(e.getX()-(r/2), e.getY()-(r/2), r, r);
        inputPoints.add(new Point(e.getX(), e.getY()));
    }
    
    public void drawPoint(Point p, int r){
        canvas.getGraphicsContext2D()
                .fillOval(p.getX()-(r/2), p.getY()-(r/2), r, r);
    }
    
    public void drawLine(Point p1, Point p2){
        canvas.getGraphicsContext2D()
                .strokeLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
    }
    
    public void clearScreen(){
        canvas.getGraphicsContext2D()
                .clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        inputPoints.clear();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
