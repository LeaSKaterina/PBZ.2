package View.Alert.AddAlert;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class AddParkAlert extends Alert {

    private final TextField idField = new TextField();
    private final TextField nameField = new TextField();

    public AddParkAlert() {
        super(Alert.AlertType.NONE);
        setTitle("Добавление парка");
        getButtonTypes().add(new ButtonType("OK"));
        GridPane gridPane = new GridPane();
        gridPane.addRow(0, new Label("ID:   "), idField);
        gridPane.addRow(1, new Label("Название"), nameField);
        getDialogPane().setContent(gridPane);

    }

    public String getParkId(){
        if (idField.getText().isEmpty()) return "не указано";
        return idField.getText();
    }

    public String getParkName(){
        if (nameField.getText().isEmpty()) return "не указано";
        return nameField.getText();
    }
}
