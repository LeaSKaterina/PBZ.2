package View.Alert.EditAlert;

import View.OptionInputBox.EditLabourerOptionInputBox;
import View.OptionInputBox.EditParkOptionInputBox;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class EditParkAlert extends Alert{

    private final TextField idField = new TextField();
    private final EditParkOptionInputBox optionInputBox = new EditParkOptionInputBox();
    private final TextField newInfoField = new TextField();

    public EditParkAlert() {
        super(Alert.AlertType.NONE);
        setTitle("Редактирование парка");
        getButtonTypes().add(new ButtonType("OK"));
        GridPane gridPane = new GridPane();

        gridPane.addRow(0, new Label("ID редактируемого парка: "), idField);
        gridPane.addRow(1, optionInputBox);
        gridPane.addRow(2, new Label("Введите новое значение поля:  ", newInfoField));
        getDialogPane().setContent(gridPane);

    }

    public String getSQL() {
        return "update PARKS_ZONES_PLANTS set " + optionInputBox.toString() + " = " +
                "'" + newInfoField.getText() + "' where PARK_ID = '" + idField.getText() + "'";

    }

}
