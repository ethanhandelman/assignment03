module com.ehandelm.assignmentthree {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires java.desktop;

    opens com.ehandelm.assignmentthree to javafx.fxml;
    exports com.ehandelm.assignmentthree;
}