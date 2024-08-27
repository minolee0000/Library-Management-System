package controller;

import java.util.ArrayList;

import com.jfoenix.controls.JFXButton;

import dto.BookDto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import tm.BookTM;
import tm.CategoryTM;

public class CRUDBookController {

    @FXML
    private JFXButton btnBookAddOnAction;

    @FXML
    private JFXButton btnBookDeleteOnAction;

    @FXML
    private JFXButton btnBookSearchOnAction1;

    @FXML
    private JFXButton btnBookUpdateOnAction;
///////////////////////////////////////////////////////////////////////////////////////////////
@FXML
private TableColumn<BookTM,String> colAuthor;

@FXML
private TableColumn<BookTM,Boolean> colBookAvailability;

@FXML
private TableColumn<BookTM,String> colBookID;

@FXML
private TableColumn<BookTM,String> colBookName;

@FXML
private TableView<BookTM> tblBooks;

//////////////////////////////////////////////////////////////////////////////////////////////
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
void bookAddOnAction(ActionEvent event) throws Exception {
    saveBook();
}

@FXML
void bookDeleteOnAction(ActionEvent event) throws Exception{
    deleteBook();
}

@FXML
void bookSearchOnAction(ActionEvent event) throws Exception {
    searchBook();
}

@FXML
void bookUpdateOnAction(ActionEvent event) throws Exception {
    updateBook();
}

@FXML
void tblMouseClickedOnAction(MouseEvent event) {
    try {
        BookTM selectedBook = tblBooks.getSelectionModel().getSelectedItem();
        if (selectedBook != null){
            txtBookID.setText(selectedBook.getBookID());
            txtBookName.setText(selectedBook.getBookName());
            txtAuthor.setText(selectedBook.getAuthor());
            txtAvailability.setText(String.valueOf(selectedBook.getAvailability()));
        }
    } catch (Exception e) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setContentText("Error in selecting a book");
        alert.show();

    }
}

private void saveBook()throws Exception{
    try {
        BookDto dto = new BookDto(txtBookID.getText(),txtBookName.getText(),txtAuthor.getText(),
                                        Boolean.parseBoolean(txtAvailability.getText()));
        String resp = BookController.save(dto);
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText(resp);
        alert.show();
        getAll();
        clearForm();

    } catch (Exception e) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setContentText("Error at saving the book");
        alert.show();
    }
}
    private void deleteBook() throws Exception{
        try {
            String resp = BookController.delete(txtBookID.getText());
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText(resp);
            alert.show();
            getAll();
            clearForm();
        } catch (Exception e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Error at deleting the book");
            alert.show();
        }
    }

    private void updateBook() throws Exception {
        try {
            BookDto bookDto = new BookDto(txtBookID.getText(),txtBookName.getText(),
                                        txtAuthor.getText(),Boolean.parseBoolean(txtAvailability.getText()));
            String resp = BookController.update(bookDto);
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText(resp);
            alert.show();
            getAll();
            clearForm();
        } catch (Exception e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Error at updating");
            alert.show();
        }
    }

    private void searchBook() throws Exception{
        try {
            BookDto bookDto = BookController.get(txtBookSearch.getText());
            if( bookDto != null){
                tblBooks.getItems().clear();
                BookTM bookTM = new BookTM(bookDto.getBookID(),bookDto.getBookName(),bookDto.getAuthor(),bookDto.getAvailability());
                tblBooks.getItems().add(bookTM);
            }else{
                Alert alert = new Alert(AlertType.WARNING);
                alert.setHeaderText(null);
                alert.setContentText("Book not Found");
                alert.show();
            }

        } catch (Exception e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Error at searching");
            alert.show();
        }
    }


    private void getAll() throws Exception{
        ObservableList<BookTM> bookTMList = FXCollections.observableArrayList();
        ArrayList <BookDto> dtos = BookController.getAll();

        for (BookDto dto : dtos){
            BookTM bookTM = new BookTM(dto.getBookID(), dto.getBookName(), dto.getAuthor(), dto.getAvailability());
            bookTMList.add(bookTM);
        }
        tblBooks.setItems(bookTMList);
    }
    
    private void clearForm(){
        txtBookID.clear();
        txtBookName.clear();
        txtAuthor.clear();
        txtAvailability.clear();
    }
    @FXML
    private void initialize() throws Exception {
        colBookID.setCellValueFactory(new PropertyValueFactory<>("bookID"));
        colBookName.setCellValueFactory(new PropertyValueFactory<>("bookName"));
        colAuthor.setCellValueFactory(new PropertyValueFactory<>("author"));
        colBookAvailability.setCellValueFactory(new PropertyValueFactory<>("availability"));

        getAll();
    }
}
