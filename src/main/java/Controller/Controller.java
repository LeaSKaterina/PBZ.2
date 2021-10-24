package Controller;

import Model.*;
import View.Alert.DatePickAlert;
import View.Alert.EditAlert.EditCompanyInfoAlert;
import View.Alert.EditAlert.EditParkAlert;
import View.Alert.PlantTypeAlert;
import View.Alert.PlantTypeAndDateAlert;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;

import java.sql.*;

public class Controller {

    private Connection connection;
    private final ParkController parkController;
    private final PlantController plantController;
    private final LabourerController labourerController;
    private final DecoratorController decoratorController;

    public Controller(String DB_URL, String DB_USER, String DB_PASSWORD, String DB_DRIVER) {
        try {
            Class.forName(DB_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        }  catch (SQLException | ClassNotFoundException throwable) {
            throwable.printStackTrace();
        }
        parkController = new ParkController(connection);
        plantController = new PlantController(connection);
        labourerController = new LabourerController(connection);
        decoratorController = new DecoratorController(connection);
    }

    public ObservableList<Object> goToHome(){
        ObservableList<Object> result = FXCollections.observableArrayList();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from COMPANY");
            ResultSet resSet = preparedStatement.executeQuery();
            while (resSet.next()) {
                String name = resSet.getString("NAME");
                String address = resSet.getString("ADDRESS");
                result.add(new Company(name, address));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }

    public ObservableList<Object> goToParks(){
        return parkController.getParksFromDB();
    }

    public ObservableList<Object> goToPlants(){
        return plantController.getPlantsFromDB();
    }

    public ObservableList<Object> goToLabourers(){
        return labourerController.getLabourersFromDB();
    }

    public ObservableList<Object> goToDecorators(){
        return decoratorController.getDecoratorsFromDB();
    }

    public void addParkProcess() {
        parkController.addProcess();
    }

    public void addPlantProcess() {
        plantController.addProcess();
    }

    public void addLabourerProcess(){
        labourerController.addProcess();
    }

    public void addDecoratorProcess(){
        decoratorController.addProcess();
    }

    public void deleteParkProcess() {
        parkController.deleteProcess();
    }

    public void deletePlantProcess() {
        plantController.deleteProcess();
    }

    public void deleteLabourerProcess(){
        labourerController.deleteProcess();
    }

    public void deleteDecoratorProcess(){
        decoratorController.deleteProcess();
    }

    public void editParkProcess() { parkController.editProcess();}

    public void editPlantProcess() {
        plantController.editProcess();
    }

    public void editLabourerProcess(){
        labourerController.editProcess();
    }

    public void editDecoratorProcess(){
        decoratorController.editProcess();
    }

    public ObservableList<Object> showPlantsByType() {
        ObservableList<Object> listOfPlants = plantController.getPlantsFromDB();

        PlantTypeAlert alert = new PlantTypeAlert();
        alert.show();

        ((Button) alert.getDialogPane().lookupButton(alert.getButtonTypes().get(0))).setOnAction((ae) -> {
            listOfPlants.removeIf(plant -> !((Plant) plant).getType().equals(alert.getType()));
            alert.close();
        });

        return listOfPlants;
    }

    public ObservableList<Object> showLabourersByDate(){
        ObservableList<Object> list = FXCollections.observableArrayList();

        DatePickAlert alert = new DatePickAlert();
        alert.show();

        ((Button) alert.getDialogPane().lookupButton(alert.getButtonTypes().get(0))).setOnAction((ae) -> {
            try {
                PreparedStatement stmt = connection.prepareStatement("select LAST_NAME, FIRST_NAME, PATRONYMIC, PHONE, DATE from LABOURERS join TIMETABLE T on LABOURERS.ID = T.LABOURER_ID where DATE = ?");
                stmt.setDate(1,alert.getDate());
                Date date3 = alert.getDate();
                ResultSet resSet = stmt.executeQuery();
                while (resSet.next()) {
                    String firstName = resSet.getString("FIRST_NAME");
                    String lastName = resSet.getString("LAST_NAME");
                    String patronymic = resSet.getString("PATRONYMIC");
                    String phone = resSet.getString("PHONE");
                    Date date = resSet.getDate("DATE");
                    list.add(new LabourerDate(lastName, firstName, patronymic, phone, date));
                }

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });

        return list;
    }


    public ObservableList<Object> showPlantsByTypeAndDate(){
        ObservableList<Object> listOfPlants = plantController.getPlantsFromDB();

        PlantTypeAndDateAlert alert = new PlantTypeAndDateAlert();
        alert.show();

        ((Button) alert.getDialogPane().lookupButton(alert.getButtonTypes().get(0))).setOnAction((ae) -> {
            listOfPlants.removeIf(plant -> !(((Plant) plant).getType().equals(alert.getType()) && ((Plant) plant).getPlantingDate().equals(alert.getDate())));
            alert.close();
        });

        return listOfPlants;
    }

    public void editCompanyInfoProcess(){
        EditCompanyInfoAlert editAlert = new EditCompanyInfoAlert();
        editAlert.show();

        ((Button) editAlert.getDialogPane().lookupButton(editAlert.getButtonTypes().get(0))).setOnAction((ae) -> {
            try {
                PreparedStatement stmt;
                stmt = connection.prepareStatement(editAlert.getSQL());
                stmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            editAlert.close();
        });
    }


}
