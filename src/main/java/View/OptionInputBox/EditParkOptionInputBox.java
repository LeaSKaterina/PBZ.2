package View.OptionInputBox;

import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;

public class EditParkOptionInputBox extends VBox {

    final private RadioButton idRBtn = new RadioButton("ID ");
    final private RadioButton nameRBtn = new RadioButton("Название   ");

    final private ToggleGroup group = new ToggleGroup();

    public EditParkOptionInputBox() {
        group.getToggles().addAll(idRBtn, nameRBtn);
        getChildren().addAll(idRBtn, nameRBtn);
    }

    public String toString() {

        if (group.getSelectedToggle() != null) {
            Toggle selectedToggle = group.getSelectedToggle();
            if (idRBtn.equals(selectedToggle)) {
                return "PARK_ID";
            }
            else if (nameRBtn.equals(selectedToggle)) {
                return "PARK_NAME";
            }
        }
        return "";
    }

}
