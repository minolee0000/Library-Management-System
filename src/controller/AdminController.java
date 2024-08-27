package controller;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AdminController {
    @FXML
    private JFXButton btnBooksOnAction;

    @FXML
    private JFXButton btnCategoryOnAction;

    @FXML
    private JFXButton btnUserOnAction;

    @FXML
    void BooksOnAction(ActionEvent event) throws IOException {
        System.out.println("Button Books Clicked");
        Parent root = FXMLLoader.load(this.getClass().getResource("/view/Book.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
        stage.setTitle("Book Information Form");
    }

    @FXML
    void categoryOnAction(ActionEvent event) throws IOException {
        System.out.println("Button Category Clicked");
        Parent root = FXMLLoader.load(this.getClass().getResource("/view/Category.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
        stage.setTitle("User Information Form");
    }

    @FXML
    void userOnAction(ActionEvent event) throws IOException {
        System.out.println("Button User Clicked");
            Parent root = FXMLLoader.load(this.getClass().getResource("/view/User.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
            stage.setTitle("User Information Form");
    }

}
