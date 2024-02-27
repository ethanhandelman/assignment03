package com.ehandelm.assignmentthree;

import javafx.application.Platform;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.List;

public class LineGraph {
    private AnchorPane graphVisual;
    private double height;
    private List<Rectangle> pointVisuals;
    private static final double X_INCREMENT = 10;
    //private double x, y;

    public LineGraph(AnchorPane graphVisual){
        this.graphVisual = graphVisual;
        this.pointVisuals = new ArrayList<>();
    }

    public void addPoint(Point2D point){
        double printX = pointVisuals.get(pointVisuals.size() - 1).getX() + X_INCREMENT;
        Rectangle rect = new Rectangle(point.getX(), point.getY(), 5, 5);
        rect.setFill(Color.BLACK);
        addChild(rect);
    }

    private void addChild(Node node){
        Platform.runLater(() ->{
            graphVisual.getChildren().add(node);
        });
    }
}
