package Controller;

import Model.Labourer;
import View.Alert.AddAlert.AddLabourerAlert;
import View.Alert.AddAlert.AddParkAlert;
import View.Alert.DeleteAlert;
import View.Alert.EditAlert.EditDecoratorAlert;
import View.Alert.EditAlert.EditLabourerAlert;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LabourerController {

    private final Connection connection;

    LabourerController(Connection connection){
        this.connection = connection;
        if (connection == null) throw new RuntimeException("Пустое соединение, пока не знаю, почему.");
    }

    public ObservableList<Object> getLabourersFromDB(){
        ObservableList<Object> result = FXCollections.observableArrayList();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from LABOURERS");
            ResultSet resSet = preparedStatement.executeQuery();
            while (resSet.next()) {
                Integer id = resSet.getInt("ID");
                String lastName = resSet.getString("LAST_NAME");
                String firstName = resSet.getString("FIRST_NAME");
                String patronymic = resSet.getString("PATRONYMIC");
                String phone = resSet.getString("PHONE");
                String address = resSet.getString("ADDRESS");

                result.add(new Labourer(id, lastName, firstName, patronymic, phone, address));
            }

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return result;
    }

    public void addProcess(){
        AddLabourerAlert addLabourerAlert = new AddLabourerAlert();
        addLabourerAlert.show();

        ((Button) addLabourerAlert.getDialogPane().lookupButton(addLabourerAlert.getButtonTypes().get(0))).setOnAction((ae) -> {
            try {
                PreparedStatement stmt = connection.prepareStatement("insert into LABOURERS (ID, LAST_NAME, FIRST_NAME, PATRONYMIC, PHONE, ADDRESS) values ( ?,?,?,?,?,? )");
                stmt.setString(1, addLabourerAlert.getId());
                stmt.setString(2, addLabourerAlert.getLastName());
                stmt.setString(3, addLabourerAlert.getFirstName());
                stmt.setString(4, addLabourerAlert.getPatronymic());
                stmt.setString(5, addLabourerAlert.getPhone());
                stmt.setString(6, addLabourerAlert.getAddress());
                stmt.executeUpdate();

                stmt = connection.prepareStatement("insert into PARK_LABOURER (PARK_ID, LABOURER_ID) values ( ?,? )");
                stmt.setString(1, addLabourerAlert.getParkId());
                stmt.setString(2, addLabourerAlert.getId());
                stmt.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }
            addLabourerAlert.close();
        });
    }

    public void deleteProcess(){
        DeleteAlert deleteAlert = new DeleteAlert("служащего");
        deleteAlert.show();

        ((Button) deleteAlert.getDialogPane().lookupButton(deleteAlert.getButtonTypes().get(0))).setOnAction((ae) -> {
            try {
                PreparedStatement stmt;

                stmt = connection.prepareStatement("delete from LABOURERS WHERE ID = ?");
                stmt.setString(1,deleteAlert.getId());
                stmt.executeUpdate();

                stmt = connection.prepareStatement("delete from PARK_LABOURER WHERE LABOURER_ID = ?");
                stmt.setString(1,deleteAlert.getId());
                stmt.executeUpdate();

                stmt = connection.prepareStatement("delete from TIMETABLE WHERE LABOURER_ID = ?");
                stmt.setString(1,deleteAlert.getId());
                stmt.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }
            deleteAlert.close();
        });
    }

    public void editProcess(){
        EditLabourerAlert editAlert = new EditLabourerAlert();
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
