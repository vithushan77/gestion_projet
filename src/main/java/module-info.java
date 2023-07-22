module com.green.gestion_projet {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.green.gestion_projet to javafx.fxml;
    exports com.green.gestion_projet;
}