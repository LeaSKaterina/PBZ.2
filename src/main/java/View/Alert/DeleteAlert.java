package View.Alert;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class DeleteAlert extends Alert {
    private final TextField idField = new TextField();

    public DeleteAlert(String whatMustBeDeleted) {
        super(Alert.AlertType.NONE);
        setTitle("Удаление " + whatMustBeDeleted);
        getButtonTypes().add(new ButtonType("OK"));
        getDialogPane().setContent(new HBox(new Label("ID:   "),idField));
    }

    public String getId() {
        return idField.getText();
    }
}
