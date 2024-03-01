package com.ehandelm.assignmentthree;

import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;

import javax.swing.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public abstract class BoxHandler {
    private AnchorPane graphVisual;
    private BoxHandler next;

    public BoxHandler() {
    }

    public abstract void handle(int size);
}