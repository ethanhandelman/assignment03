package com.ehandelm.assignmentthree;

import javafx.geometry.Point2D;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public class Repository {
    //this is an example of the Singleton pattern
    private static Repository _instance;
    private PropertyChangeSupport changes = new PropertyChangeSupport(this);
    private List<Point2D> points;
    private double xTracker;

    private Repository(){
        points = new ArrayList<>();
        xTracker = -LineGraph.X_INCREMENT;
    }

    public void addVal(Point2D val){
        points.add(val);
        changes.firePropertyChange("newVal", null, val);
    }

    public double getAverage(){
        if (points.isEmpty()) {
            return 0.0;
        }

        double sum = 0.0;
        for (Point2D point : points) {
            sum += point.getY();
        }
        return sum / points.size();
    }

    public void addPropertyChangeListener(PropertyChangeListener l){
        changes.addPropertyChangeListener(l);
    }

    public Point2D getLastPoint(){
        if(points.isEmpty()){
            return new Point2D(0, 0);
        }
        else if(points.size() == 1){
            return points.get(0);
        }
        else{
            return points.get(points.size() - 2);
        }
    }

    public double getNextX(){
        xTracker += LineGraph.X_INCREMENT;
        return xTracker;
    }

    public static Repository getInstance(){
        if(_instance == null){
            _instance = new Repository();
        }
        return _instance;
    }

}
