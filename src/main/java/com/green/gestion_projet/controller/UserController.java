package com.green.gestion_projet.controller;

import com.green.gestion_projet.models.entities.User;
import com.green.gestion_projet.services.UserService;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.util.List;

public class UserController {

    @FXML
    private TableView<User> tableView;

    @FXML
    private TableColumn<User, String> nameColumn;

    @FXML
    private TableColumn<User, String> firstnameColumn;

    @FXML
    private TableColumn<User, String> mailColumn;

    @FXML
    private TableColumn<User, String> roleColumn;

    @FXML
    public void initialize() {
        // Create an object of UserService to interact with the API
        UserService userService = new UserService();

        // Get the list of all users from the API
        List<User> userList = List.of(userService.getAll());

        // Bind the list of users to the TableView
        tableView.getItems().addAll(userList);

        // Configure cell factories for TableView columns
        nameColumn.setCellValueFactory(cellData -> {
            User user = cellData.getValue();
            return new SimpleStringProperty(user.getFirstName());
        });

        firstnameColumn.setCellValueFactory(cellData -> {
            User user = cellData.getValue();
            return new SimpleStringProperty(user.getLastName());
        });

        mailColumn.setCellValueFactory(cellData -> {
            User user = cellData.getValue();
            return new SimpleStringProperty(user.getEmail());
        });

        roleColumn.setCellValueFactory(cellData -> {
            User user = cellData.getValue();
            return new SimpleStringProperty(user.getRole().getName());
        });
    }
}
