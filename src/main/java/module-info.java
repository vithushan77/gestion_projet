module com.green.gestion_projet {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;
    requires net.synedra.validatorfx;
    requires jakarta.xml.bind;


    opens com.green.gestion_projet to javafx.fxml;
    exports com.green.gestion_projet;
    exports com.green.gestion_projet.controller;
    opens com.green.gestion_projet.controller to javafx.fxml;
    opens com.green.gestion_projet.models.entities to com.google.gson;
    exports com.green.gestion_projet.models.entities;
    exports com.green.gestion_projet.models;
    opens com.green.gestion_projet.models to com.google.gson;
    exports com.green.gestion_projet.services;
    opens com.green.gestion_projet.services to com.google.gson;
    exports com.green.gestion_projet.applications;
    opens com.green.gestion_projet.applications to com.google.gson;
    exports com.green.gestion_projet.utils;
    opens com.green.gestion_projet.utils to com.google.gson;


}

