package Controller;

import Model.Decorator;
import View.Alert.AddAlert.AddDecoratorAlert;
import View.Alert.DeleteAlert;
import View.Alert.EditAlert.EditDecoratorAlert;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DecoratorController {

    private final Connection connection;

    DecoratorController(Connection connection){
        this.connection = connection;
        if (connection == null) throw new RuntimeException("Пустое соединение, пока не знаю, почему.");
    }

    public ObservableList<Object> getDecoratorsFromDB(){
        ObservableList<Object> result = FXCollections.observableArrayList();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from DECORATORS");
            ResultSet resSet = preparedStatement.executeQuery();
            while (resSet.next()) {
                Integer id = resSet.getInt("ID");
                String lastName = resSet.getString("LAST_NAME");
                String firstName = resSet.getString("FIRST_NAME");
                String patronymic = resSet.getString("PATRONYMIC");
                String phone = resSet.getString("PHONE");
                String address = resSet.getString("ADDRESS");
                String education = resSet.getString("EDUCATION");
                String nameOfInstitution = resSet.getString("NAME_OF_INSTITUTION");
                String category = resSet.getString("CATEGORY");

                result.add(new Decorator(id, lastName, firstName, patronymic, phone, address, education, nameOfInstitution, category));
            }

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return result;
    }

    public void addProcess(){
        AddDecoratorAlert addDecoratorAlert = new AddDecoratorAlert();
        addDecoratorAlert.show();

        ((Button) addDecoratorAlert.getDialogPane().lookupButton(addDecoratorAlert.getButtonTypes().get(0))).setOnAction((ae) -> {
            try {
                PreparedStatement stmt = connection.prepareStatement("insert into DECORATORS (ID, LAST_NAME, FIRST_NAME, PATRONYMIC, PHONE, ADDRESS, EDUCATION, NAME_OF_INSTITUTION, CATEGORY) values ( ?,?,?,?,?,?,?,?,? )");
                stmt.setString(1, addDecoratorAlert.getId());
                stmt.setString(2, addDecoratorAlert.getLastName());
                stmt.setString(3, addDecoratorAlert.getFirstName());
                stmt.setString(4, addDecoratorAlert.getPatronymic());
                stmt.setString(5, addDecoratorAlert.getPhone());
                stmt.setString(6, addDecoratorAlert.getAddress());
                stmt.setString(7, addDecoratorAlert.getEducation());
                stmt.setString(8, addDecoratorAlert.getNameOfInstitution());
                stmt.setString(9, addDecoratorAlert.getCategory());
                stmt.executeUpdate();

                stmt = connection.prepareStatement("insert into PARK_DECORATOR (PARK_ID, DECORATOR_ID) values (?,?);");
                stmt.setString(1, addDecoratorAlert.getParkId());
                stmt.setString(2, addDecoratorAlert.getId());
                stmt.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }
            addDecoratorAlert.close();
        });
    }

    public void deleteProcess(){
        DeleteAlert deleteAlert = new DeleteAlert("декоратора");
        deleteAlert.show();

        ((Button) deleteAlert.getDialogPane().lookupButton(deleteAlert.getButtonTypes().get(0))).setOnAction((ae) -> {
            try {
                PreparedStatement stmt;

                stmt = connection.prepareStatement("delete from DECORATORS WHERE ID = ?");
                stmt.setString(1,deleteAlert.getId());
                stmt.executeUpdate();

                stmt = connection.prepareStatement("delete from PARK_DECORATOR WHERE DECORATOR_ID = ?");
                stmt.setString(1,deleteAlert.getId());
                stmt.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }
            deleteAlert.close();
        });
    }

    public void editProcess(){
        EditDecoratorAlert editAlert = new EditDecoratorAlert();
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
