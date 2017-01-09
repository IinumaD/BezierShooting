/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shooting;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
    private List<Point> inputPoints = new ArrayList<>();
    private BezierCurve bezier;
    
    @Override
    public void start(Stage primaryStage) {
        
        canvas.setOnMouseClicked(this::drawPoint);
        Button clearBtn = new Button("Clear");
        clearBtn.setOnMouseClicked((MouseEvent e) -> {
            clearScreen();
        });
        Button lineBtn = new Button("Draw");
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
        
        Pane pane = new Pane(canvas);
        pane.getChildren().add(clearBtn);
        pane.getChildren().add(lineBtn);
        pane.getChildren().add(bezierBtn);
        Scene scene = new Scene(pane);
        
        clearBtn.relocate(0, 0);
        lineBtn.relocate(50, 0);
        bezierBtn.relocate(100, 0);

        primaryStage.setTitle("Shoot!!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public void drawPoint(MouseEvent e){
        int r = 3;
        canvas.getGraphicsContext2D().strokeOval(e.getX()-(r/2), e.getY()-(r/2), r, r);
        inputPoints.add(new Point(e.getX(), e.getY()));
    }
    
    public void drawLine(Point p1, Point p2){
        canvas.getGraphicsContext2D().strokeLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
    }
    
    public void clearScreen(){
        canvas.getGraphicsContext2D().clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        inputPoints.clear();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
