package com.ehandelm.assignmentthree;

import javafx.geometry.Point2D;
import javafx.scene.Node;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public class Repository {
    //this is an example of the Singleton pattern
    private static Repository _instance;

    private PropertyChangeSupport changes = new PropertyChangeSupport(this);

    private List<Point2D> points;


    private Repository(){
        points = new ArrayList<>();
        points.add(new Point2D(0, 0));
    }

    public void addVal(Point2D val){
        changes.firePropertyChange("newVal", null, val);
        points.add(val);
    }

    public void addPropertyChangeListener(PropertyChangeListener l){
        changes.addPropertyChangeListener(l);
    }

    public Point2D getLastPoint(){
        return points.get(points.size() - 1);
    }
    public static Repository getInstance(){
        if(_instance == null){
            _instance = new Repository();
        }
        return _instance;
    }

}
