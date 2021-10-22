package View.Alert;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class PlantTypeAlert extends Alert{
    private final TextField typeField = new TextField();

    public PlantTypeAlert() {
        super(Alert.AlertType.NONE);
        setTitle("Ввод типа:)");
        getButtonTypes().add(new ButtonType("OK"));
        getDialogPane().setContent(new HBox(new Label("Тип растения:   "), typeField));
    }

    public String getType() {
        return typeField.getText();
    }
}
