package View.Alert;

import View.MyDatePicker;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.sql.Date;

public class PlantTypeAndDateAlert extends Alert {

    private final TextField typeField = new TextField();
    private final MyDatePicker datePicker = new MyDatePicker();

    public PlantTypeAndDateAlert() {
        super(Alert.AlertType.NONE);
        setTitle("Ввод типа и даты:");
        GridPane pane = new GridPane();
        pane.addRow(0, new Label("Тип растения:   "), typeField);
        pane.addRow(1, new Label("Дата:   "), datePicker);

        getButtonTypes().add(new ButtonType("OK"));
        getDialogPane().setContent(pane);
    }

    public String getType() {
        return typeField.getText();
    }

    public Date getDate() { return datePicker.getDateValue(); }
}
