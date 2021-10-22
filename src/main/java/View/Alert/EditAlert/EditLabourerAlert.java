package View.Alert.EditAlert;

import View.OptionInputBox.EditLabourerOptionInputBox;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class EditLabourerAlert extends Alert {

    private final TextField idField = new TextField();
    private final EditLabourerOptionInputBox optionInputBox = new EditLabourerOptionInputBox();
    private final TextField newInfoField = new TextField();

    public EditLabourerAlert() {
        super(Alert.AlertType.NONE);
        setTitle("Редактирование служащего");
        getButtonTypes().add(new ButtonType("OK"));
        GridPane gridPane = new GridPane();

        gridPane.addRow(0, new Label("ID редактируемого служащего: "), idField);
        gridPane.addRow(1, optionInputBox);
        gridPane.addRow(2, new Label("Введите новое значение поля:  ", newInfoField));
        getDialogPane().setContent(gridPane);

    }

    public String getSQL() {
        return "update LABOURERS set " + optionInputBox.toString() + " = " +
                "'" + newInfoField.getText() + "' where ID = '" + idField.getText() + "'";

    }
}
