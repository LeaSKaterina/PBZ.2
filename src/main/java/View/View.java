package View;

import Controller.Controller;
import View.Table.*;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class View extends GridPane {
    private TableView table;

    private final Controller controller;

    public View(String DB_URL, String DB_USER, String DB_PASSWORD, String DB_DRIVER){

        setVgap(10);

        Button homeBtn = new Button("На главную");
        Button parksBtn = new Button("Парки");
        Button plantsBtn = new Button("Растения");
        Button labourersBtn = new Button("Служители парков");
        Button decoratorsBtn = new Button("Декораторы парков");
        add(new VBox(homeBtn, parksBtn, plantsBtn, labourersBtn, decoratorsBtn), 0,0);

        GridPane daughterPane = new GridPane();

        Button addParkBtn = new Button("Добавить парк");
        Button editParkBtn = new Button("Отредактировать парк");
        Button deleteParkBtn = new Button("Удалить парк");
        daughterPane.addRow(0,addParkBtn,editParkBtn,deleteParkBtn);

        Button addPlantBtn = new Button("Добавить растение");
        Button editPlantBtn = new Button("Отредактировать растение");
        Button deletePlantBtn = new Button("Удалить растение");
        daughterPane.addRow(1, addPlantBtn, editPlantBtn, deletePlantBtn);

        Button addLabourerBtn = new Button("Добавить служащего");
        Button editLabourerBtn = new Button("Отредактировать служащего");
        Button deleteLabourerBtn = new Button("Удалить служащего");
        daughterPane.addRow(2,addLabourerBtn, editLabourerBtn, deleteLabourerBtn);

        Button addDecoratorBtn = new Button("Добавить декоратора");
        Button editDecoratorBtn = new Button("Отредактировать декоратора");
        Button deleteDecoratorBtn = new Button("Удалить декоратора");
        daughterPane.addRow(3, addDecoratorBtn, editDecoratorBtn, deleteDecoratorBtn);

        add(new Separator(),0,1);
        add(daughterPane,0,2);

        add(new Separator(),0,3);

        Button showPlantsByType = new Button("Показать растения заданного типа");
        Button showLabourersByDate = new Button("Показать список сотрудников, работающих на заданную дату");
        Button showPlantsByTypeAndDate = new Button("Показать перечень всех растений заданного вида на текущую дату");
        add(new VBox(showPlantsByType, showLabourersByDate, showPlantsByTypeAndDate),0,4);

        table = new CompanyTable();
        controller = new Controller(DB_URL,DB_USER, DB_PASSWORD, DB_DRIVER);
        table.setItems(controller.goToHome());
        add(table, 1,0,1,5);

        homeBtn.setOnAction((ae) -> {
            table = new CompanyTable();
            updateTable(controller.goToHome());
        });

        parksBtn.setOnAction((ae) -> {
            table = new ParkTable();
            updateTable(controller.goToParks());
        });

        plantsBtn.setOnAction(ae -> {
            table = new PlantTable();
            updateTable(controller.goToPlants());
        });
        labourersBtn.setOnAction(ae -> {
            table = new LabourerTable();
            updateTable(controller.goToLabourers());
        });
        decoratorsBtn.setOnAction(ae -> {
            table = new DecoratorTable();
            updateTable(controller.goToDecorators());
        });

        addParkBtn.setOnAction(ae -> {controller.addParkProcess();});
        addPlantBtn.setOnAction(ae -> {controller.addPlantProcess();});
        addLabourerBtn.setOnAction(ae ->{controller.addLabourerProcess();});
        addDecoratorBtn.setOnAction(ae ->{controller.addDecoratorProcess();});

        deleteParkBtn.setOnAction(ae -> {controller.deleteParkProcess();});
        deletePlantBtn.setOnAction(ae -> {controller.deletePlantProcess();});
        deleteLabourerBtn.setOnAction(ae ->{controller.deleteLabourerProcess();});
        deleteDecoratorBtn.setOnAction(ae ->{controller.deleteDecoratorProcess();});

        editParkBtn.setOnAction(ae -> {controller.editParkProcess();});
        editPlantBtn.setOnAction(ae -> {controller.editPlantProcess();});
        editLabourerBtn.setOnAction(ae ->{controller.editLabourerProcess();});
        editDecoratorBtn.setOnAction(ae ->{controller.editDecoratorProcess();});

        showPlantsByType.setOnAction(ae -> {
            table = new PlantTable();
            updateTable(controller.showPlantsByType());
        });
        showLabourersByDate.setOnAction(ae ->{
            table = new LabourerDateTable();
            updateTable(controller.showLabourersByDate());
        });
        showPlantsByTypeAndDate.setOnAction(ae -> {});

    }

    private void updateTable(ObservableList<Object> list){
        table.setItems(list);
        add(table,1,0,1,3);
    }

}
