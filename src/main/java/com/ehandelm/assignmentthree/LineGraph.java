package com.ehandelm.assignmentthree;

import javafx.application.Platform;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class LineGraph implements PropertyChangeListener {
    private AnchorPane graphVisual;
    private Line avgLine;
    public static final double X_INCREMENT = 15;

    public LineGraph(AnchorPane graphVisual){
        this.graphVisual = graphVisual;
        avgLine = new Line(-50, MainController.GRAPH_HEIGHT, MainController.VIEWABLE_GRAPH_WIDTH + 50, MainController.GRAPH_HEIGHT);
        avgLine.setStroke(Color.RED);
        addChild(avgLine);
        Repository.getInstance().addPropertyChangeListener(this);
    }

    public void addPoint(Point2D point){
        /*Rectangle rect = new Rectangle(point.getX()- 2.5, point.getY() - 2.5, 5, 5);
        rect.setFill(Color.BLACK);
        addChild(rect);*/
        Point2D last = Repository.getInstance().getLastPoint();
        Line line = new Line(last.getX(), last.getY(), point.getX(), point.getY());
        line.setStrokeWidth(1);
        line.setStroke(Color.BLUE);
        addChild(line);

        drawAverageLine();

        if(point.getX() > MainController.VIEWABLE_GRAPH_WIDTH - 10){
            reAlignGraph();
        }
    }

    private void reAlignGraph(){
        graphVisual.setTranslateX(graphVisual.getTranslateX() - X_INCREMENT);
    }

    private void addChild(Node node){
        Platform.runLater(() ->{
            graphVisual.getChildren().add(node);
        });
    }

    private void drawAverageLine(){
        avgLine.setEndX(graphVisual.getBoundsInLocal().getWidth() + 50);
        avgLine.setStartY(Repository.getInstance().getAverage());
        avgLine.setEndY(Repository.getInstance().getAverage());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt){
        Point2D newPoint = (Point2D) evt.getNewValue();
        addPoint(newPoint);
    }
}
