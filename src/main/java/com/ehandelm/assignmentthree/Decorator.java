package com.ehandelm.assignmentthree;

import javafx.geometry.Point2D;

import java.beans.PropertyChangeEvent;

public class Decorator extends Component {

    private Component component;


    public Decorator(Component component){
        super(component.graphVisual);
        this.component = component;
    }

    @Override
    public void addPoint(Point2D point) {
        if(component == null) return;
        component.addPoint(point);
    }


    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if(component == null) return;
        component.propertyChange(evt);
        addPoint((Point2D) evt.getNewValue());
    }
}
