package View.Alert.AddAlert;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class AddLabourerAlert extends Alert {

    private final TextField parkIdField = new TextField();
    private final TextField idField = new TextField();
    private final TextField lastNameField = new TextField();
    private final TextField firstNameField = new TextField();
    private final TextField patronymicField = new TextField();
    private final TextField phoneField = new TextField();
    private final TextField addressField = new TextField();

    public AddLabourerAlert() {
        super(Alert.AlertType.NONE);
        setTitle("Добавление служащего");
        getButtonTypes().add(new ButtonType("OK"));
        GridPane gridPane = new GridPane();
        gridPane.addRow(0, new Label("ID парка:   "), parkIdField);
        gridPane.addRow(1, new Label("ID служащего:   "), idField);
        gridPane.addRow(2, new Label("Фамилия:   "), lastNameField);
        gridPane.addRow(3, new Label("Имя:   "), firstNameField);
        gridPane.addRow(4, new Label("Отчество:   "), patronymicField);
        gridPane.addRow(6, new Label("Телефон:   "), phoneField);
        gridPane.addRow(7, new Label("Адрес:   "), addressField);
        getDialogPane().setContent(gridPane);

    }

    private String getFieldValue(TextField field) {
        if (field.getText().isEmpty()) return "не указано";
        return field.getText();
    }

    public String getParkId() {
        return getFieldValue(parkIdField);
    }

    public String getId() {
        return getFieldValue(idField);
    }

    public String getLastName() {
        return getFieldValue(lastNameField);
    }

    public String getFirstName() {
        return getFieldValue(firstNameField);
    }

    public String getPatronymic() {
        return getFieldValue(patronymicField);
    }

    public String getPhone() {
        return getFieldValue(phoneField);
    }

    public String getAddress() {
        return getFieldValue(addressField);
    }
}
