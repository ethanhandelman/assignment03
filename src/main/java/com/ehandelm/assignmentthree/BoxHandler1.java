package com.ehandelm.assignmentthree;

import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class BoxHandler1 extends BoxHandler {

    Rectangle rect1;

    public BoxHandler1() {
        this.rect1 = new Rectangle(200, 400, Color.ORANGE);
        this.rect1.setLayoutX(200);
        this.rect1.setLayoutY(400);
        this.rect1.setWidth(5);
        this.rect1.setHeight(5);
    }

    public void expandBox1() {
        this.rect1.setWidth(this.rect1.getWidth()*1.5);
        this.rect1.setHeight(this.rect1.getHeight()*1.5);
    }

    @Override
    public void handle(int size) {
        if (size > 90) {
            expandBox1();
        }
    }


}