package Controller;

import Model.Park;
import View.Alert.AddAlert.AddParkAlert;
import View.Alert.DeleteAlert;
import View.Alert.EditAlert.EditParkAlert;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ParkController {

    private final Connection connection;

    ParkController(Connection connection){
        this.connection = connection;
        if (connection == null) throw new RuntimeException("Пустое соединение, пока не знаю, почему.");
    }

    public ObservableList<Object> getParksFromDB(){
        ObservableList<Object> result = FXCollections.observableArrayList();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select distinct PARK_ID, PARK_NAME from PARKS_ZONES_PLANTS");
            ResultSet resSet = preparedStatement.executeQuery();
            while (resSet.next()) {
                Integer id = resSet.getInt("PARK_ID");
                String name = resSet.getString("PARK_NAME");
                result.add(new Park(id, name));
            }

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return result;
    }

    public void addProcess() {
        AddParkAlert addParkAlert = new AddParkAlert();
        addParkAlert.show();

        ((Button) addParkAlert.getDialogPane().lookupButton(addParkAlert.getButtonTypes().get(0))).setOnAction((ae) -> {
            try {
                PreparedStatement stmt = connection.prepareStatement("insert into PARKS_ZONES_PLANTS ( PARK_ID, PARK_NAME ) values (?,?) ");
                stmt.setString(1, addParkAlert.getParkId());
                stmt.setString(2, addParkAlert.getParkName());
                stmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            addParkAlert.close();
        });
    }

    public void deleteProcess(){
        DeleteAlert deleteAlert = new DeleteAlert("парка");
        deleteAlert.show();

        ((Button) deleteAlert.getDialogPane().lookupButton(deleteAlert.getButtonTypes().get(0))).setOnAction((ae) -> {
            try {
                PreparedStatement stmt;

                stmt = connection.prepareStatement("delete from PARKS_ZONES_PLANTS WHERE PARK_ID = ?");
                stmt.setString(1,deleteAlert.getId());
                stmt.executeUpdate();

                stmt = connection.prepareStatement("delete from PARK_DECORATOR WHERE PARK_ID = ?");
                stmt.setString(1,deleteAlert.getId());
                stmt.executeUpdate();

                stmt = connection.prepareStatement("delete from PARK_LABOURER WHERE PARK_ID = ?");
                stmt.setString(1,deleteAlert.getId());
                stmt.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }
            deleteAlert.close();
        });
    }

    public void editProcess(){
        EditParkAlert editAlert = new EditParkAlert();
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
