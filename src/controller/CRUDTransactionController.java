package controller;

import java.util.ArrayList;

import com.jfoenix.controls.JFXButton;

import dto.TransactionDto;
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
import javafx.scene.layout.AnchorPane;
import tm.TransactionTM;


public class CRUDTransactionController {


    @FXML
    private JFXButton btnAddOAction;

    @FXML
    private JFXButton btnDeleteOnAction;

    @FXML
    private JFXButton btnUpdateOnAction;

    @FXML
    private TableColumn<TransactionTM, String> colBookID;

    @FXML
    private TableColumn<TransactionTM, Double> colFine;

    @FXML
    private TableColumn<TransactionTM, String> colReleasedDate;

    @FXML
    private TableColumn<TransactionTM, String> colTransID;

    @FXML
    private TableColumn<TransactionTM,String> colUserID;

    @FXML
    private AnchorPane root;

    @FXML
    private TextField txtBookID;

    @FXML
    private TextField txtReleasedDate;

    @FXML
    private TextField txtTransID;

    @FXML
    private TextField txtUserID;

    @FXML
    private TableView<TransactionTM> tblTrasaction;


    @FXML
    void addOnAction(ActionEvent event) throws Exception{
        saveTransaction();
    }

    @FXML
    void deleteOnAction(ActionEvent event) {
        deleteTransaction();
    }

    @FXML
    void mouseClickedOnAction(MouseEvent event) {
        try {
            TransactionTM selectedTransaction = tblTrasaction.getSelectionModel().getSelectedItem();
            if (selectedTransaction != null){
                txtTransID.setText(selectedTransaction.getTransactionID());
                txtBookID.setText(selectedTransaction.getBookID());
                txtUserID.setText(selectedTransaction.getUserID());
                txtReleasedDate.setText(selectedTransaction.getReleasedDate());
            }
        } catch (Exception e) {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setHeaderText(null);
            alert.setContentText("No transaction is selected");
            alert.show();
        }
    }

    @FXML
    void updateOnAction(ActionEvent event) {

    }

    private void saveTransaction()throws Exception{
        try {
            TransactionDto transactionDto = new TransactionDto(txtTransID.getText(),txtBookID.getText(),txtUserID.getText(),txtReleasedDate.getText());
            String resp = TransactionController.save(transactionDto);
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText(resp);
            alert.show();
            getAll();
            clearForm();
        } catch (Exception e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Error at saving");
            alert.show();
        }    
    }

    private void deleteTransaction(){
        try {
            String resp = TransactionController.delete(txtTransID.getText());
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText(resp);
            alert.show();
            getAll();
        } catch (Exception e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Error at deleting");
            alert.show();
        }
    }

    private void getAll()throws Exception{
        ObservableList <TransactionTM> transactionTMList=  FXCollections.observableArrayList();
        ArrayList <TransactionDto> dtos = TransactionController.getAll();

        for (TransactionDto dto : dtos){
            TransactionTM transactionTM =new TransactionTM(dto.getTransactionID(),
                                                            dto.getBookID(),
                                                            dto.getUserID(),
                                                            dto.getReleasedDate(),
                                                            dto.getFine()) ;
            transactionTMList.add(transactionTM);
        }
        tblTrasaction.setItems(transactionTMList);
        
    }

    @FXML
    private void initialize()throws Exception{
        colTransID.setCellValueFactory(new PropertyValueFactory<>("transactionID"));
        colBookID.setCellValueFactory(new PropertyValueFactory<>("bookID"));
        colUserID.setCellValueFactory(new PropertyValueFactory<>("userID"));
        colReleasedDate.setCellValueFactory(new PropertyValueFactory<>("releasedDate"));
        colFine.setCellValueFactory(new PropertyValueFactory<>("fine"));

        getAll();
    }

    private void clearForm(){
        txtTransID.clear();
        txtBookID.clear();
        txtUserID.clear();
        txtReleasedDate.clear();
    }

}


