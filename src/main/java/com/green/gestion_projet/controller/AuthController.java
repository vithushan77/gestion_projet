package com.green.gestion_projet.controller;

import com.green.gestion_projet.services.AuthService;
import com.green.gestion_projet.singletons.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import net.synedra.validatorfx.Check;
import net.synedra.validatorfx.TooltipWrapper;
import net.synedra.validatorfx.Validator;


import java.util.Objects;

public class AuthController {

    private final Validator validator = new Validator();
    public VBox credentialsVBox;
    public VBox emailVBox;
    public TextField emailTextField;
    public VBox passwordVBox;
    public PasswordField passwordField;
    public Button loginWithEmailBtn;
    public Label forgotPassword;
    private boolean showPassword = false;


    public void initialize() {

        Check emailCheck = validator.createCheck()
                .dependsOn("email", emailTextField.textProperty())
                .withMethod(c -> {
                    String email = c.get("email");
                    if (!email.contains("@")) {
                        c.error("Please enter a valid email address.");
                    }

                })
                .decorates(emailTextField);

        loginWithEmailBtn.disableProperty().bind(validator.containsErrorsProperty());

        TooltipWrapper<Button> loginWithEmailWrapper = new TooltipWrapper<>(
                loginWithEmailBtn,
                validator.containsErrorsProperty(),
                validator.createStringBinding()
        );

        passwordVBox.managedProperty().bind(passwordVBox.visibleProperty());
        passwordVBox.setVisible(false);

        credentialsVBox.getChildren().add(loginWithEmailWrapper);


        // when typing in email, recheck password
        emailTextField.setOnKeyReleased(event -> emailCheck.recheck());

    }

    @FXML
    public void loginWithEmail() {
        boolean userExists = AuthService.userExists(emailTextField.getText());

        if (userExists) {
            validator.createCheck()
                    .dependsOn("password", passwordField.textProperty())
                    .withMethod(c -> {
                        String password = c.get("password");
                        if (password.isEmpty()) {
                            c.error("Password is required.");
                        }
                    })
                    .decorates(passwordField)
                    .immediate();

            // if validator contains no errors, then login
            if (showPassword && !validator.containsErrorsProperty().get()) {
                String authToken = AuthService.authenticate(emailTextField.getText(), passwordField.getText());
                if (authToken != null) {
                    AuthService.fetchUser(authToken);
                    SceneManager.getInstance().switchToScene("/main.fxml", null, null, scene -> {
                        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/css/styles.css")).toExternalForm());
                        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/css/kanban.css")).toExternalForm());
                        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/css/hierarchy.css")).toExternalForm());
                        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/css/settings.css")).toExternalForm());
                        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/css/organization.css")).toExternalForm());
                        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/css/popover.css")).toExternalForm());
                    });
                } else {
                    System.out.println("Authentication failed");
                }
            }

            showPassword = true;
            passwordVBox.setVisible(true);
        } else {
            passwordVBox.setVisible(false);
            showPassword = false;
        }
    }
}
