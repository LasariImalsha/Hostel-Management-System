package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;

public class LoginFormController {
    public AnchorPane mainContext;

    public void loginOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/DashboardForm.fxml");
        Parent load = FXMLLoader.load(resource);
        mainContext.getChildren().clear();
        mainContext.getChildren().add(load);

    }
}
