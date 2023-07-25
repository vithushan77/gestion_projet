package com.green.gestion_projet.controller;

import com.green.gestion_projet.models.entities.Project;
import com.green.gestion_projet.services.ProjectService;
import com.green.gestion_projet.singletons.SceneManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class MainController {

    @FXML
    private Label labelDone;

    @FXML
    private Label labelInprogress;

    @FXML
    private Label labelTodo;

    @FXML
    private Button ButtonUser;
    private ObservableList<Project> projectsList = FXCollections.observableArrayList();
    @FXML
    private TableView<Project> projectsTableView;
    @FXML
    private TableColumn<Project, String> nameColumn;
    @FXML
    private TableColumn<Project, String> descriptionColumn;

    public void initialize() {
        // Appeler ici des méthodes pour récupérer les noms des statuts depuis la base de données
      /*  String inprogressStatus = getStatusFromDatabase("inprogress");
        String todoStatus = getStatusFromDatabase("todo");
        String doneStatus = getStatusFromDatabase("done");*/
        ButtonUser.setOnAction(this::handleButtonClick);

        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));

        // Load projects from the database and add them to the TableView
        ProjectService projectService = new ProjectService();
        Project[] projects = projectService.getAll();
        projectsList.addAll(projects);
        projectsTableView.setItems(projectsList);

    }


    @FXML
    private void handleButtonClick(ActionEvent event) {
        if (event.getSource() == ButtonUser) {
            SceneManager.getInstance().switchToScene("/com/green/gestion_projet/user.fxml", null, null, scene -> {
            });
        } else {
            System.out.println("Authentication failed");
        }
    }

}
