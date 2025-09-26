module se.kth.saeedvan.shapes_javafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires jdk.xml.dom;


    opens se.kth.saeedvan.shapes_javafx to javafx.fxml;
    exports se.kth.saeedvan.shapes_javafx;
}