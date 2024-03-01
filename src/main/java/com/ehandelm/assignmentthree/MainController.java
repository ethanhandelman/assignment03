package com.ehandelm.assignmentthree;

import javafx.fxml.FXML;
import javafx.geometry.Point2D;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.util.Random;

public class MainController {
    @FXML
    private Button addButton;
    @FXML
    private AnchorPane graphBox1, graphBox2, graphBox3;

    public static final double GRAPH_HEIGHT = 150;
    public static final double VIEWABLE_GRAPH_WIDTH = 300;

    public static double genRandomDouble(double max) {
        return genRandomDouble(0, max);
    }

    public static double genRandomDouble(double min, double max) {
        Random random = new Random();
        return min + (max - min) * random.nextDouble();
    }

    @FXML
    protected void onAddButtonClick() {
        Point2D newPoint;
        newPoint = new Point2D(Repository.getInstance().getNextX(), genRandomDouble(GRAPH_HEIGHT));
        Repository.getInstance().addVal(newPoint);
    }

    @FXML
    private void initialize() {
        LineGraph graph1 = new LineGraph(graphBox3);
        Repository.getInstance().addPropertyChangeListener(graph1);
        LineGraph graph2 = new LineGraph(graphBox2);
        SquareDecorator squareDecorator = new SquareDecorator(graph2);
        Repository.getInstance().addPropertyChangeListener(squareDecorator);
        LineGraph graph3 = new LineGraph(graphBox1);
        SquareDecorator squareDecorator2 = new SquareDecorator(graph3);
        BarDecorator barDecorator = new BarDecorator(squareDecorator2);
        Repository.getInstance().addPropertyChangeListener(barDecorator);
    }

}