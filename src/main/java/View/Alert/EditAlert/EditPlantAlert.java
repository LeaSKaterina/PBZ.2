package View.Alert.EditAlert;

import View.OptionInputBox.EditPlantOptionInputBox;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class EditPlantAlert  extends Alert {

    private final TextField idField = new TextField();
    private final EditPlantOptionInputBox optionInputBox = new EditPlantOptionInputBox();
    private final TextField newInfoField = new TextField();

    public EditPlantAlert() {
        super(Alert.AlertType.NONE);
        setTitle("Редактирование растения");
        getButtonTypes().add(new ButtonType("OK"));
        GridPane gridPane = new GridPane();

        gridPane.addRow(0, new Label("ID редактируемого растения: "), idField);
        gridPane.addRow(1, optionInputBox);
        gridPane.addRow(2, new Label("Введите новое значение поля:  ", newInfoField));
        getDialogPane().setContent(gridPane);

    }

    public String getSQL() {

        if (optionInputBox.editWateringOption()){
            return "update WATERING set " + optionInputBox.toString() + " = '" + newInfoField.getText() + "' " +
                    "where ID = (select distinct WATERING_ID from PLANTS where ID = '" + idField.getText() + "')";
        }
        return "update PLANTS set " + optionInputBox.toString() + " = " +
                "'" + newInfoField.getText() + "' where ID = '" + idField.getText() + "'";

    }

}