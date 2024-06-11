module org.example.ergueiasmaos {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens org.example.ergueiasmaos to javafx.fxml;
    exports org.example.ergueiasmaos;
}