package com.ehandelm.assignmentthree;

import javafx.application.Platform;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;

import java.beans.PropertyChangeListener;

public abstract class Component implements PropertyChangeListener {
    AnchorPane graphVisual;

    public Component(AnchorPane graphVisual){
        this.graphVisual = graphVisual;
    }

    public abstract void addPoint(Point2D point);
    public void addChild(Node node){
        Platform.runLater(() ->{
            graphVisual.getChildren().add(node);
        });
    }
}
