package Controller;

import Model.FrequencyEnum;
import Model.Plant;
import Model.Watering;
import View.Alert.AddAlert.AddPlantAlert;
import View.Alert.DeleteAlert;
import View.Alert.EditAlert.EditPlantAlert;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;

import java.sql.*;
import java.util.Date;

public class PlantController {

    private final Connection connection;

    PlantController(Connection connection){
        this.connection = connection;
        if (connection == null) throw new RuntimeException("Пустое соединение, пока не знаю, почему.");
    }

    public ObservableList<Object> getPlantsFromDB(){
        ObservableList<Object> result = FXCollections.observableArrayList();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from PLANTS join WATERING on PLANTS.WATERING_ID = WATERING.ID");
            ResultSet resSet = preparedStatement.executeQuery();
            while (resSet.next()) {
                Integer id = resSet.getInt("PLANTS.ID");
                Date date = resSet.getDate("DATE");
                Short age = resSet.getShort("AGE");
                String type = resSet.getString("TYPE");

                Integer watering_id = resSet.getInt("WATERING_ID");
                FrequencyEnum frequency = FrequencyEnum.initFrequency(resSet.getString("FREQUENCY"));
                Time time = resSet.getTime("TIME");
                Float amountOfWater = resSet.getFloat("AMOUNT_OF_WATER");

                result.add(new Plant(id, date, age, type,new Watering(watering_id, frequency, time, amountOfWater)));
            }

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return result;
    }

    public void addProcess() {
        AddPlantAlert addPlantAlert = new AddPlantAlert();
        addPlantAlert.show();

        ((Button) addPlantAlert.getDialogPane().lookupButton(addPlantAlert.getButtonTypes().get(0))).setOnAction((ae) -> {
            try {
                PreparedStatement stmt = connection.prepareStatement("insert into PARKS_ZONES_PLANTS ( PARK_ID, ZONE_ID, PLANT_ID ) values (?,?,?);");
                stmt.setString(1, addPlantAlert.getParkId());
                stmt.setString(2, addPlantAlert.getZoneId());
                stmt.setString(3, addPlantAlert.getPlantId());
                stmt.executeUpdate();

                stmt = connection.prepareStatement("update PARKS_ZONES_PLANTS set PARK_NAME = (select distinct PARK_NAME from PARKS_ZONES_PLANTS where PARK_ID = ? and PARK_NAME is not null) where PARK_ID = ?;");
                stmt.setString(1, addPlantAlert.getParkId());
                stmt.setString(2, addPlantAlert.getParkId());

                stmt = connection.prepareStatement("insert into PLANTS ( ID, DATE, AGE, TYPE, WATERING_ID ) values (?,?,?,?,?);");
                stmt.setString(1, addPlantAlert.getPlantId());
                stmt.setString(2, addPlantAlert.getDateValue());
                stmt.setString(3, addPlantAlert.getAge());
                stmt.setString(4, addPlantAlert.getType());
                stmt.setString(5, addPlantAlert.getWateringId());
                stmt.executeUpdate();

                stmt = connection.prepareStatement("insert into WATERING(ID, FREQUENCY, TIME, AMOUNT_OF_WATER) values ( ?,?,?,? );");
                stmt.setString(1, addPlantAlert.getWateringId());
                stmt.setString(2, addPlantAlert.getWateringFrequency());
                stmt.setString(3, addPlantAlert.getWateringTime());
                stmt.setString(4, addPlantAlert.getWateringAmount());
                stmt.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }
            addPlantAlert.close();
        });
    }

    public void deleteProcess(){
        DeleteAlert deleteAlert = new DeleteAlert("растения");
        deleteAlert.show();

        ((Button) deleteAlert.getDialogPane().lookupButton(deleteAlert.getButtonTypes().get(0))).setOnAction((ae) -> {
            try {
                PreparedStatement stmt;

                stmt = connection.prepareStatement("delete from PARKS_ZONES_PLANTS WHERE PLANT_ID = ?");
                stmt.setString(1,deleteAlert.getId());
                stmt.executeUpdate();

                stmt = connection.prepareStatement("delete from PLANTS WHERE ID = ?");
                stmt.setString(1,deleteAlert.getId());
                stmt.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }
            deleteAlert.close();
        });
    }

    public void editProcess(){
        EditPlantAlert editAlert = new EditPlantAlert();
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
