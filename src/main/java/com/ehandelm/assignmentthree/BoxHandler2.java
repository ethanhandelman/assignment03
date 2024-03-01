package com.ehandelm.assignmentthree;

import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class BoxHandler2 extends BoxHandler {
    Rectangle rect1;
    Rectangle rect2;
    Rectangle rect3;
    protected BoxHandler successor;
    public BoxHandler2() {
        this.rect1 = new Rectangle(100, 100, Color.RED);
        this.rect1.setLayoutX(100);
        this.rect1.setLayoutY(100);
        this.rect1.setWidth(5);
        this.rect1.setHeight(5);
        this.rect2 = new Rectangle(200, 100, Color.PURPLE);
        this.rect2.setLayoutX(200);
        this.rect2.setLayoutY(100);
        this.rect2.setWidth(5);
        this.rect2.setHeight(5);
        this.rect3 = new Rectangle(100, 400, Color.GREEN);
        this.rect3.setLayoutX(100);
        this.rect3.setLayoutY(400);
        this.rect3.setWidth(5);
        this.rect3.setHeight(5);
    }

    public void setSuccessor(BoxHandler successor){
        this.successor = successor;
    }

    public void expandBox1() {
        this.rect1.setWidth(this.rect1.getWidth()*1.5);
        this.rect1.setHeight(this.rect1.getHeight()*1.5);
    }

    public void expandBox2() {
        this.rect2.setWidth(this.rect2.getWidth()*1.5);
        this.rect2.setHeight(this.rect2.getHeight()*1.5);
    }

    public void expandBox3() {
        this.rect2.setWidth(this.rect2.getWidth()*1.5);
        this.rect2.setHeight(this.rect2.getHeight()*1.5);
    }

    @Override
    public void handle(int size) {
        if (size <= 30) {
            expandBox1();
        } else if (size <= 60) {
            expandBox2();
        } else if (size <= 90) {
            expandBox3();
        } else if (successor != null){
            successor.handle(size);
        }
    }
}