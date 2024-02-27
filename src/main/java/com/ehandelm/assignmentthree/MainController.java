package com.ehandelm.assignmentthree;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.util.Random;

public class MainController {
    @FXML
    private Button addButton;
    @FXML
    private AnchorPane graphBox1, graphBox2, graphBox3;

    public static final double GRAPH_HEIGHT = 150;
    public static final double X_INCREMENT = 10;

    public static double genRandomDouble(double max){
        return genRandomDouble(0, max);
    }

    public static double genRandomDouble(double min, double max) {
        Random random = new Random();
        return min + (max - min) * random.nextDouble();
    }
    @FXML
    protected void onAddButtonClick() {

    }

    @FXML
    private void initialize(){

    }

}