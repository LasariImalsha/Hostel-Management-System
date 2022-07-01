package controller;

import bo.BOFactory;
import bo.custom.StudentBO;
import dto.StudentDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;


public class ManageStudentFormController {

    public TextField txtStuId;
    public TextField txtName;
    public TextField txtBirthDate;
    public TextField txtNic;
    public TextField txtAddress;
    public TextField txtPhoneNumber;
    public TextField txtEmail;

    public TableView<StudentDTO> tblStudent;

    public TableColumn<StudentDTO,String> colStuId;
    public TableColumn<StudentDTO,String> colName;
    public TableColumn<StudentDTO,String> colDOB;
    public TableColumn<StudentDTO,String> colNIC;
    public TableColumn<StudentDTO,String> colAddress;
    public TableColumn<StudentDTO,String> colPhnNumber;
    public TableColumn<StudentDTO,String> colEmail;

    private final StudentBO studentBO = BOFactory.getInstance().getBO(BOFactory.BOType.STUDENT);

    ObservableList<StudentDTO> obList = FXCollections.observableArrayList();

    public void initialize(){
        showValidation();

    try {
        viewAllStudents();
    } catch (Exception e){
        e.printStackTrace();
    }

        colStuId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colDOB.setCellValueFactory(new PropertyValueFactory<>("dob"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colNIC.setCellValueFactory(new PropertyValueFactory<>("nic"));
        colPhnNumber.setCellValueFactory(new PropertyValueFactory<>("phoneNo"));

        tblStudent.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue)-> {
            setStudentData(newValue);
                }
        );
    }

    private void setStudentData(StudentDTO s1) {
        txtStuId.setText(s1.getId());
        txtName.setText(s1.getName());
        txtBirthDate.setText(s1.getDob());
        txtAddress.setText(s1.getAddress());
        txtEmail.setText(s1.getEmail());
        txtNic.setText(s1.getNic());
        txtPhoneNumber.setText(s1.getPhoneNo());

    }

    private void viewAllStudents() throws Exception {
        obList.clear();
        List<StudentDTO> items=studentBO.searchAll();
        obList.addAll(items);
        tblStudent.setItems(obList);
    }

    private void showValidation() {
    }

    private void clearFields() {
        txtStuId.clear();
        txtEmail.clear();
        txtPhoneNumber.clear();
        txtAddress.clear();
        txtNic.clear();
        txtBirthDate.clear();
        txtName.clear();
    }

    public void UpdateOnAction(ActionEvent actionEvent) throws Exception {
        // if (ValidationUtil.isAllValidated(validationList)){
        StudentDTO item1 = new StudentDTO(txtStuId.getText(),txtName.getText(),txtBirthDate.getText(),txtNic.getText(),txtAddress.getText(),txtPhoneNumber.getText(),txtEmail.getText());
        if (studentBO.update(item1)) {
            new Alert(Alert.AlertType.CONFIRMATION, "Updated..").show();
            viewAllStudents();
            clearFields();
        }else {
            new Alert(Alert.AlertType.WARNING, "Try Again").show();
        }
        // }else{
        //   new Alert(Alert.AlertType.WARNING, "Fields are not filled properly..").show();
        //}
    }
}

