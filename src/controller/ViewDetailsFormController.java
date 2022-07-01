package controller;

import bo.BOFactory;
import bo.custom.DetailBO;
import dto.DetailDTO;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Duration;
import model.tm.DetailTM;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

public class ViewDetailsFormController {

    public TableView<String> tblDetail;
    public TableColumn<DetailDTO,String> colDetailId;
    public TableColumn<DetailDTO,String> colStuDetail;
    public TableColumn<DetailDTO,String> colPayDetail;
    public TableColumn<DetailDTO,String> colRegisterDate;

    public Label lblDate;
    public Label lblTime;

    ObservableList<DetailTM> obList= FXCollections.observableArrayList();
    private final DetailBO detailBO= BOFactory.getInstance().getBO(BOFactory.BOType.DETAIL);


    public void initialize() {

        loadDateAndTime();
        showValidation();
        try {
            viewAllDetails();
        } catch (Exception e) {
            e.printStackTrace();
        }

        colStuDetail.setCellValueFactory(new PropertyValueFactory<>("student"));
        colPayDetail.setCellValueFactory(new PropertyValueFactory<>("program"));
        colRegisterDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        colDetailId.setCellValueFactory(new PropertyValueFactory<>("id"));


        //listenFieldChange(validationList);
    }

    private void showValidation() {
    }

    private void viewAllDetails() throws Exception {
        obList.clear();
        List<DetailTM> details=detailBO.searchAll();
        obList.addAll(details);
        //tblDetail.setItems(obList);
    }

    private void loadDateAndTime() {
        Date date = new Date();
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        lblDate.setText(f.format(date));

        Timeline time = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            LocalTime currentTime = LocalTime.now();
            lblTime.setText(currentTime.format(DateTimeFormatter.ofPattern("hh:mm:ss a"))
            );
        }),
                new KeyFrame(Duration.seconds(1))
        );
        time.setCycleCount(Animation.INDEFINITE);
        time.play();
    }
}

