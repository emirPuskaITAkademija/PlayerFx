module com.lines.connected.playerfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.lines.connected.playerfx to javafx.fxml;
    opens com.lines.connected.playerfx.product.dao.entity to javafx.base;
    exports com.lines.connected.playerfx;
}