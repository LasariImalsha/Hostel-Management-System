package controller;

import bo.BOFactory;
import bo.custom.RoomBO;
import dto.RoomDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

public class ManageRoomFormController {

    public TextField txtId;
    public TextField txtDuration;
    public TextField txtKeyMoney;
    public TextField txtState;
    public TextField txtType;

    public TextField txtId1;
    public TextField txtDuration1;
    public TextField txtKeyMoney1;
    public TextField txtState1;
    public TextField txtType1;

    public TableView<RoomDTO> tblRoom;
    public TableColumn<RoomDTO,String> colId;
    public TableColumn<RoomDTO,String> colType;
    public TableColumn<RoomDTO,String> colDuration;
    public TableColumn<RoomDTO,String> colKeyMoney;
    public TableColumn<RoomDTO,String> colState;

    ObservableList<RoomDTO> obList= FXCollections.observableArrayList();

    private final RoomBO roomBO= BOFactory.getInstance().getBO(BOFactory.BOType.ROOM);

    public void initialize() {
        showValidation();
        try {
            viewAllRooms();
        } catch (Exception e) {
            e.printStackTrace();
        }

        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colType.setCellValueFactory(new PropertyValueFactory<>("name"));
        colDuration.setCellValueFactory(new PropertyValueFactory<>("duration"));
        colKeyMoney.setCellValueFactory(new PropertyValueFactory<>("keyMoney"));
        colState.setCellValueFactory(new PropertyValueFactory<>("status"));


        tblRoom.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
                    setRoomData(newValue);
                }
        );
    }
    private void setRoomData(RoomDTO i) {
        if(i!=null) {
            txtId.setText(i.getId());
            txtType.setText(i.getType());
            txtDuration.setText(i.getDuration());
            txtKeyMoney.setText(String.valueOf(i.getKeyMoney()));
            txtState.setText(String.valueOf(i.getStatus()));

            txtId1.setText(i.getId());
            txtType1.setText(i.getType());
            txtDuration1.setText(i.getDuration());
            txtKeyMoney1.setText(String.valueOf(i.getKeyMoney()));
            txtState1.setText(String.valueOf(i.getStatus()));

        }
    }

    private void viewAllRooms() throws Exception {
        obList.clear();
        List<RoomDTO> rooms=roomBO.searchAll();
        obList.addAll(rooms);
        tblRoom.setItems(obList);
    }

    private void showValidation() {
    }

    /*public void addOnAction(ActionEvent actionEvent) throws Exception {
        // if (ValidationUtil.isAllValidated(validationList)){
        RoomDTO item1 = new RoomDTO(txtId.getText(),txtType.getText(),txtDuration.getText(),Double.parseDouble(txtKeyMoney.getText()));
        if(roomBO.add(item1)) {
            new Alert(Alert.AlertType.CONFIRMATION, "Saved..").show();
            viewAllRooms();
            clearFields();
        }else {
            new Alert(Alert.AlertType.WARNING, "Try Again..").show();
        }
        // }else{
        //  new Alert(Alert.AlertType.WARNING, "Fields are not filled properly..").show();
        // }

    }*/

    public void deleteOnAction(ActionEvent actionEvent)throws Exception {
        //   if (ValidationUtil.isAllValidated(validationList)){
        if (roomBO.delete(txtId1.getText())){
            new Alert(Alert.AlertType.CONFIRMATION, "Deleted").show();
            viewAllRooms();
            clearFields();
        }else{
            new Alert(Alert.AlertType.WARNING, "Try Again").show();
        }
        // }else{
        //  new Alert(Alert.AlertType.WARNING, "Fields are not filled properly..").show();
        // }
    }

    /*public void UpdateOnAction(ActionEvent actionEvent)throws Exception {
        // if (ValidationUtil.isAllValidated(validationList)){
        RoomDTO room1 = new RoomDTO(txtId1.getText(),txtType1.getText(),txtDuration1.getText(),Double.parseDouble(txtKeyMoney1.getText(),Double.parseDouble(txtState1.getText()));
        if (roomBO.update(room1)) {
            new Alert(Alert.AlertType.CONFIRMATION, "Updated..").show();
            viewAllRooms();
            clearFields();
        }else {
            new Alert(Alert.AlertType.WARNING, "Try Again").show();
        }
        //}else{
        //  new Alert(Alert.AlertType.WARNING, "Fields are not filled properly..").show();
        //}

    }*/

    private void clearFields() {
        txtId.clear();
        txtType.clear();
        txtDuration.clear();
        txtKeyMoney.clear();
        txtState.clear();
        txtId1.clear();
        txtType1.clear();
        txtDuration1.clear();
        txtKeyMoney1.clear();
        txtState1.clear();

    }
}
