package com.ehandelm.assignmentthree;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

public class BoxPanel extends AnchorPane implements PropertyChangeListener {
    private BoxHandler2 handler2;
    private BoxHandler1 handler1;
    private AnchorPane split;
    private List<Shape> squares;

    public BoxPanel(AnchorPane s) {
        squares = Repository.getInstance().getSquares();
        split = s;
        handler2 = new BoxHandler2();
        handler1 = new BoxHandler1();
        handler2.setSuccessor(handler1);
        squares.add(handler2.rect1);
        squares.add(handler2.rect2);
        squares.add(handler2.rect3);
        squares.add(handler1.rect1);
        Repository.getInstance().addPropertyChangeListener(this);
    }

    private void addChild(Node node){
        split.getChildren().remove(node);
        Platform.runLater(() ->{
            split.getChildren().add(node);
        });
    }

    private void paintComponent(){
        int i = 0;
        while(i < 4){
            addChild(squares.get(i));
            i++;
        }
    }
    private void updateSquare(Point2D point){
        handler2.handle(((int) point.getY()));
        paintComponent();
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        Point2D newPoint = (Point2D) evt.getNewValue();
        updateSquare(newPoint);
    }
}
