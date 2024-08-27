package controller;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AdminLoginController {
    @FXML
    private JFXButton btnAdminLoginOnAction;

    @FXML
    private TextField txtAdminPw;

    @FXML
    private TextField txtAdminUser_name;
    
    @FXML
    void adminLoginOnAction(ActionEvent event) throws IOException {
        if (txtAdminUser_name.getText().equals("admin") && txtAdminPw.getText().equals("0000")){
            System.out.println("Button Admin Login Clicked");
            Parent root = FXMLLoader.load(this.getClass().getResource("/view/Admin.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
            stage.setTitle("Admin Login Form");
        }else{
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Invalid Login");
            alert.show();
            txtAdminUser_name.clear();
            txtAdminPw.clear();
;
        }
    }
}
