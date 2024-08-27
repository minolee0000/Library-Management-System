package controller;

import java.util.ArrayList;

import com.jfoenix.controls.JFXButton;

import dto.CategoryDto;
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
import tm.CategoryTM;

public class CRUDCategoryController {

    @FXML
    private JFXButton btnCategoryAddOnAction;

    @FXML
    private JFXButton btnCategoryDeleteOnAction;

    @FXML
    private JFXButton btnCategorySearchOnAction1;

    @FXML
    private JFXButton btnCategoryUpdateOnAction;
///////////////////////////////////////////////////////////////////////////////////////
    @FXML
    private TableColumn<CategoryTM, String> colCategoryId;

    @FXML
    private TableColumn<CategoryTM, String> colCategoryName;

    @FXML
    private TableColumn<CategoryTM, String> colQty;

    @FXML
    private TableView<CategoryTM> tblCategory;
/////////////////////////////////////////////////////////////////////////////////
    @FXML
    private TextField txtCategoryID;

    @FXML
    private TextField txtCategoryName;

    @FXML
    private TextField txtCategorySearch;

    @FXML
    private TextField txtQty;
/////////////////////////////////////////////////////////////////////////////////////////
    @FXML
    void categoryAddOnAction(ActionEvent event) throws Exception {
        saveCategory();
    }

    @FXML
    void categoryDeleteOnAction(ActionEvent event) throws Exception {
        deleteCategory();
    }

    @FXML
    void categorySearchOnAction(ActionEvent event) throws Exception {
        searchCategory();
    }

    @FXML
    void categoryUpdateOnAction(ActionEvent event) throws Exception {
        updateCategory();
    }

    private void saveCategory() throws Exception{
        try {
            CategoryDto dto = new CategoryDto(txtCategoryID.getText(),txtCategoryName.getText(),Integer.parseInt(txtQty.getText()));   
            System.out.println(); 
            String resp = CategoryController.save(dto);
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText(resp);
            alert.show();
            clearForm();
            getAll();
        } catch (Exception e) {
            System.out.println("Fail");
            Alert alert = new Alert(AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Error at saving data");
            alert.show();
            clearForm();
        }   
    }

    private void deleteCategory() throws Exception{
        try {
            String resp = CategoryController.delete(txtCategoryID.getText());
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText(resp);
            alert.show();
            getAll();
        } catch (Exception e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Error at deleting data");
            alert.show();
        }
    }

    private void updateCategory()throws Exception{
        try {
            CategoryDto dto = new CategoryDto(txtCategoryID.getText(),
                                                        txtCategoryName.getText(),
                                                        Integer.parseInt(txtQty.getText()));
            String resp = CategoryController.update(dto);
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText(resp);
            alert.show();
            clearForm();
            getAll();
        } catch (Exception e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Error at updating category");
            alert.show();
            clearForm();          
        }
    }

    private void searchCategory() throws Exception {
        try {
            CategoryDto dto = CategoryController.get(txtCategorySearch.getText());
            if (dto!= null){
                tblCategory.getItems().clear();
                CategoryTM categoryTM = new CategoryTM(dto.getCategoryID(),dto.getCategoryName(),dto.getQtyOfBooks());
                tblCategory.getItems().add(categoryTM);

            }else{
                Alert alert = new Alert(AlertType.WARNING);
                alert.setHeaderText(null);
                alert.setContentText("Category Not found");
                alert.show();
                clearForm();
            }
        } catch (Exception e) {
            e.printStackTrace();
            Alert alert = new Alert(AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Error at searching");
            alert.show();
        }   
    }

    private void getAll() throws Exception{
        ObservableList <CategoryTM> categoryTMList = FXCollections.observableArrayList();

        ArrayList <CategoryDto> dtos = CategoryController.getAll();

        for (CategoryDto dto : dtos){
            CategoryTM categoryTM = new CategoryTM(dto.getCategoryID(),dto.getCategoryName(),dto.getQtyOfBooks());
            categoryTMList.add(categoryTM);
        }
        tblCategory.setItems(categoryTMList);
    }


    @FXML
    private void initialize() throws Exception{
        colCategoryId.setCellValueFactory(new PropertyValueFactory<>("categoryID"));
        colCategoryName.setCellValueFactory(new PropertyValueFactory<>("categoryName"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("qtyOfBooks"));

        getAll();
    }

  
    private void clearForm(){
        txtCategoryID.clear();
        txtCategoryName.clear();
        txtQty.clear();
    }

    @FXML
    void mouseClickOnAction(MouseEvent event) {
        try {
            CategoryTM selectedCategory = tblCategory.getSelectionModel().getSelectedItem();
            if (selectedCategory != null){
                txtCategoryID.setText(selectedCategory.getCategoryID());
                txtCategoryName.setText(selectedCategory.getCategoryName());
                txtQty.setText(String.valueOf(selectedCategory.getQtyOfBooks()));
            }
        } catch (Exception e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("No category is selected");
            alert.show();
        }
    }
}
