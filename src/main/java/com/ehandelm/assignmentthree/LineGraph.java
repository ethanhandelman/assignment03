package com.ehandelm.assignmentthree;

import javafx.application.Platform;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

public class LineGraph implements PropertyChangeListener {
    private AnchorPane graphVisual;
    private double height;
    private List<Rectangle> pointVisuals;

    public static final double X_INCREMENT = 15;
    //private double x, y;

    public LineGraph(AnchorPane graphVisual){
        this.graphVisual = graphVisual;
        this.pointVisuals = new ArrayList<>();
        Repository.getInstance().addPropertyChangeListener(this);
    }

    public void addPoint(Point2D point){
        //double printX = pointVisuals.get(pointVisuals.size() - 1).getX() + X_INCREMENT;
        /*Rectangle rect = new Rectangle(point.getX()- 2.5, point.getY() - 2.5, 5, 5);
        rect.setFill(Color.BLACK);
        addChild(rect);*/
        Point2D last = Repository.getInstance().getLastPoint();
        Line line = new Line(last.getX(), last.getY(), point.getX(), point.getY());
        line.setStrokeWidth(1);
        addChild(line);
    }

    private void addChild(Node node){
        Platform.runLater(() ->{
            graphVisual.getChildren().add(node);
        });
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt){
        Point2D newPoint = (Point2D) evt.getNewValue();
        addPoint(newPoint);
    }
}
