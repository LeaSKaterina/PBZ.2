package View.OptionInputBox;

import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;

public class EditCompanyInfoOptionInputBox extends HBox {

    final private RadioButton nameRBtn = new RadioButton("Название   ");
    final private RadioButton addressRBtn = new RadioButton("Адрес  ");

    final private ToggleGroup group = new ToggleGroup();

    public EditCompanyInfoOptionInputBox() {
        group.getToggles().addAll(addressRBtn, nameRBtn);
        getChildren().addAll(addressRBtn, nameRBtn);
    }

    public String toString() {

        if (group.getSelectedToggle() != null) {
            Toggle selectedToggle = group.getSelectedToggle();
            if (addressRBtn.equals(selectedToggle)) {
                return "ADDRESS";
            }
            else if (nameRBtn.equals(selectedToggle)) {
                return "NAME";
            }
        }
        return "";
    }
}
