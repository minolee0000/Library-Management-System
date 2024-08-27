package controller;

import java.util.ArrayList;

import com.jfoenix.controls.JFXButton;


import dto.UserDto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import tm.UserTM;
import javafx.scene.control.Alert.AlertType;

public class CRUDUserController {
///////////////////////////////////////////////////////////////////////////////////////////////////    
    @FXML
    private JFXButton btnUserAddOnAction;

    @FXML
    private JFXButton btnUserDeleteOnAction;

    @FXML
    private JFXButton btnUserUpdateOnAction;

    @FXML
    private JFXButton btnUserSearch;

///////////////////////////////////////////////////////////////////////////////////////////////////
    @FXML
    private TableColumn<UserTM, String> colAddress;

    @FXML
    private TableColumn<UserTM, String> colContactNumber;

    @FXML
    private TableColumn<UserTM, String> colJoinedDate;

    @FXML
    private TableColumn<UserTM, String> colUserID;

    @FXML
    private TableColumn<UserTM, String> colUserName;

    @FXML
    private TableView<UserTM> tblUser;
/////////////////////////////////////////////////////////////////////////////////////////////////////////
    @FXML
    private TextField txtUserAddress;

    @FXML
    private TextField txtUserContactNo;

    @FXML
    private TextField txtUserID;

    @FXML
    private TextField txtUserName;

    @FXML
    private TextField txtUserJoinedDate;

    @FXML
    private TextField txtUserSearch;
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @FXML
    void userAddOnAction(ActionEvent event) {
        System.out.println("User save button clicked");
        saveUser();
        System.out.println("User saved");
    }

    @FXML
    void userDeleteOnAction(ActionEvent event) throws Exception {
        System.out.println("Delete Button clicked");
        deleteUser();
        System.out.println("User deleted");
    }

    @FXML
    void userUpdateOnAction(ActionEvent event) throws Exception {
        System.out.println("update button clicked");
        updateUser();
        System.out.println("User updated");
    }

    @FXML
    void userSearchOnAction(ActionEvent event) {
        searchUser();
    }

    private void saveUser(){
        try {
            UserDto dto = new UserDto(txtUserID.getText(),txtUserName.getText(),txtUserAddress.getText(),txtUserContactNo.getText(),txtUserJoinedDate.getText());
            String resp = userController.save(dto);
            Alert alert =new Alert (AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText(resp);
            alert.show();
            clearForm();
            getAll();
        } catch (Exception e) {
            Alert alert =new Alert (AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Failed to save data");
            alert.show();
            clearForm();
        }
    }

    private void updateUser() {
        try {
            UserDto dto = new UserDto(txtUserID.getText(),txtUserName.getText(),txtUserAddress.getText(),txtUserContactNo.getText(),txtUserJoinedDate.getText());
            String resp = userController.update(dto);

            System.out.println(resp);

            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText(resp);
            alert.show();
            clearForm();
            getAll();
        } catch (Exception e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Fail to update Data");
            alert.show();
            clearForm();        
        }
    }

    private void deleteUser() throws Exception{
        try {
            String resp = userController.delete(txtUserID.getText());
            Alert alert =new Alert (AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText(resp);
            alert.show();
            getAll();  
            clearForm();
        } catch (Exception e) {
            Alert alert =new Alert (AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("User Account is not clear");
            alert.show();
            clearForm();
        }
        
    }

    private void searchUser(){
            try {
                UserDto dto = userController.get(txtUserSearch.getText());
                if (dto != null) {
                    tblUser.getItems().clear();

                    UserTM userTM = new UserTM(dto.getId(), dto.getName(), dto.getAddress(), dto.getContact_number(), dto.getJoinedDate());
                    tblUser.getItems().add(userTM);
                } else {
                    Alert alert = new Alert(AlertType.WARNING);
                    alert.setHeaderText(null);
                    alert.setContentText("User not found");
                    alert.show();
                }
            } catch (Exception e) {
                e.printStackTrace();
                Alert alert = new Alert(AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("Error occurred while searching for the user");
                alert.show();
            }
        }
        
    

    @FXML
    private void initialize() throws Exception {
        colUserID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colUserName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colContactNumber.setCellValueFactory(new PropertyValueFactory<>("contact_number"));
        colJoinedDate.setCellValueFactory(new PropertyValueFactory<>("joinedDate"));
    
        getAll();
    }
    
    private void getAll() throws Exception{
        ObservableList<UserTM> userTMList = FXCollections.observableArrayList();

        ArrayList <UserDto> userList = userController.getAll();
        for (UserDto user: userList){
            UserTM userTM = new UserTM(user.getId(),user.getName(),user.getAddress(),user.getContact_number(),user.getJoinedDate());
                                                    
            userTMList.add(userTM);

        }
        System.out.println(userTMList);
        tblUser.setItems(userTMList);
    }

    @FXML
    void mouseClickOnAction(MouseEvent event) {
        try {
            UserTM selectedUser = tblUser.getSelectionModel().getSelectedItem();

            if (selectedUser != null){
                txtUserID.setText(selectedUser.getId());
                txtUserName.setText(selectedUser.getName());
                txtUserAddress.setText(selectedUser.getAddress());
                txtUserContactNo.setText(selectedUser.getContact_number());
                txtUserJoinedDate.setText(selectedUser.getJoinedDate());
            }else{
                Alert alert = new  Alert(AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("No user is selected");
                alert.show();

            }
        } catch (Exception e) {
           e.printStackTrace();
           Alert alert = new Alert(AlertType.ERROR);
           alert.setHeaderText(null);
           alert.setContentText("Error at loading Data");
           alert.show();
        }
    }
    
    private void clearForm (){
        txtUserID.clear();
        txtUserName.clear();
        txtUserAddress.clear();
        txtUserContactNo.clear();
        txtUserContactNo.clear();
        txtUserJoinedDate.clear();
    }
}
