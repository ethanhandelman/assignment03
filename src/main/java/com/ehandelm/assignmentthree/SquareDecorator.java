package com.ehandelm.assignmentthree;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.beans.PropertyChangeEvent;

public class SquareDecorator extends Decorator {
    public SquareDecorator(Component component) {
        super(component);
    }

    @Override
    public void addPoint(Point2D point) {
        super.addPoint(point);
        Rectangle rect = new Rectangle(point.getX()- 2.5, point.getY() - 2.5, 5, 5);
        rect.setWidth(7);
        rect.setHeight(7);
        rect.setFill(Color.BLUE);
        addChild(rect);
    }


}
