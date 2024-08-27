package controller;

import com.jfoenix.controls.JFXButton;

import dto.BookDto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;

public class CRUDBookController {

    @FXML
    private JFXButton btnBookAddOnAction;

    @FXML
    private JFXButton btnBookDeleteOnAction;

    @FXML
    private JFXButton btnBookSearchOnAction1;

    @FXML
    private JFXButton btnBookUpdateOnAction;

    @FXML
    private TableColumn<?, ?> colAuthor;

    @FXML
    private TableColumn<?, ?> colBookAvailability;

    @FXML
    private TableColumn<?, ?> colBookID;

    @FXML
    private TableColumn<?, ?> colBookName;

    @FXML
    private TableColumn<?, ?> colBookName12;

    @FXML
    private TableView<?> tblBooks;

    @FXML
    private TextField txtAuthor;

    @FXML
    private TextField txtAvailability;

    @FXML
    private TextField txtBookID;

    @FXML
    private TextField txtBookName;

    @FXML
    private TextField txtBookSearch;

    @FXML
    void bookAddOnAction(ActionEvent event) {
        saveBook();
    }

    @FXML
    void bookDeleteOnAction(ActionEvent event) {
        deleteBook();
    }

    @FXML
    void bookSearchOnAction(ActionEvent event) {

    }

    @FXML
    void bookUpdateOnAction(ActionEvent event) {

    }

    @FXML
    void tblMouseClickedOnAction(MouseEvent event) {

    }

    private void saveBook(){
        try {
            BookDto dto = new BookDto(txtBookID.getText(),txtBookName.getText(),txtAuthor.getText(),
                                        Boolean.parseBoolean(txtAvailability.getText()));
            String resp = BookController.save(dto);
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText(resp);
            alert.show();
            getAll();

        } catch (Exception e) {
            
        }
        
    }
    private void deleteBook(){

    }

    private void getAll(){

    }
    
    private void clearForm(){
        txtBookID.clear();
        txtBookName.clear();
        txtAuthor.clear();
        txtAvailability.clear();
    }
}
