package controller;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class MainController {
    
    @FXML
    private JFXButton btnAdminOnAction;

    @FXML
    private JFXButton btnUserOnAction;
    
    @FXML
    private AnchorPane root;

    @FXML
    void btnAdminAction(ActionEvent event) throws IOException {
        System.out.println("Button Admin Clicked");
        Parent root = FXMLLoader.load(this.getClass().getResource("/view/AdminLogin.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
        stage.setTitle("Admin Login Form");
    }

    @FXML
    void btnUserOnAction(ActionEvent event)throws IOException {
       System.out.println("Button User Clicked");
        Parent root = FXMLLoader.load(this.getClass().getResource("/view/UserLogin.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
        stage.setTitle("User Login Form");
       
    }

}
