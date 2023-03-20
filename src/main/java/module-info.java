module com.lines.connected.playerfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.lines.connected.playerfx to javafx.fxml;
    exports com.lines.connected.playerfx;
}