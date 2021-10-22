package View.Alert.EditAlert;

import View.OptionInputBox.EditDecoratorOptionInputBox;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class EditDecoratorAlert extends Alert {

    private final TextField idField = new TextField();
    private final EditDecoratorOptionInputBox optionInputBox = new EditDecoratorOptionInputBox();
    private final TextField newInfoField = new TextField();

    public EditDecoratorAlert() {
        super(Alert.AlertType.NONE);
        setTitle("Редактирование декоратора");
        getButtonTypes().add(new ButtonType("OK"));
        GridPane gridPane = new GridPane();

        gridPane.addRow(0, new Label("ID редактируемого декоратора: "), idField);
        gridPane.addRow(1, optionInputBox);
        gridPane.addRow(2, new Label("Введите новое значение поля:  ", newInfoField));
        getDialogPane().setContent(gridPane);

    }

    public String getSQL() {
        return "update DECORATORS set " + optionInputBox.toString() + " = " +
                "'" + newInfoField.getText() + "' where ID = '" + idField.getText() + "'";

    }
}
