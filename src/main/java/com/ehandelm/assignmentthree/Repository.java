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
    }

    public void addVal(Point2D val){
        points.add(val);
        changes.firePropertyChange("newVal", null, val);
    }

    public void addPropertyChangeListener(PropertyChangeListener l){
        changes.addPropertyChangeListener(l);
    }

    public static Repository getInstance(){
        if(_instance == null){
            _instance = new Repository();
        }
        return _instance;
    }

}
