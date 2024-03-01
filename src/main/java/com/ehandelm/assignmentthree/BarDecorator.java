package com.ehandelm.assignmentthree;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.beans.PropertyChangeEvent;

public class BarDecorator extends Decorator {
    public BarDecorator(Component component) {
        super(component);
    }

    @Override
    public void addPoint(Point2D point) {
        super.addPoint(point);

        double baseLineY = MainController.GRAPH_HEIGHT;
        double rectHeight = Math.abs(baseLineY - point.getY());
        double rectY = point.getY() < baseLineY ? point.getY() : baseLineY - rectHeight;

        Rectangle rect = new Rectangle(point.getX() - 2.5, rectY, 5, rectHeight);
        rect.setFill(Color.BLACK);
        addChild(rect);
    }
}
