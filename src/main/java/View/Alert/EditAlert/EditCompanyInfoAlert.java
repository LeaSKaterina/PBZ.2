package View.Alert.EditAlert;

import View.OptionInputBox.EditCompanyInfoOptionInputBox;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class EditCompanyInfoAlert extends Alert {

    private final EditCompanyInfoOptionInputBox optionInputBox = new EditCompanyInfoOptionInputBox();
    private final TextField newInfoField = new TextField();

    public EditCompanyInfoAlert() {
        super(Alert.AlertType.NONE);
        setTitle("Редактирование данных о компании");
        getButtonTypes().add(new ButtonType("OK"));
        GridPane gridPane = new GridPane();

        gridPane.addRow(1, optionInputBox);
        gridPane.addRow(2, new Label("Введите новое значение поля:  ", newInfoField));
        getDialogPane().setContent(gridPane);

    }

    public String getSQL() {
        return "update COMPANY set " + optionInputBox.toString() + " = " +
                "'" + newInfoField.getText() + "'";
    }


}
