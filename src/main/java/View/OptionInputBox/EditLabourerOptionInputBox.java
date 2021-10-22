package View.OptionInputBox;

import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;

public class EditLabourerOptionInputBox extends VBox {

    final private RadioButton idRBtn = new RadioButton("ID ");
    final private RadioButton lastNameRBtn = new RadioButton("Фамилия   ");
    final private RadioButton firstNameRBtn = new RadioButton("Имя  ");
    final private RadioButton patronymicRBtn = new RadioButton("Отчество    ");
    final private RadioButton phoneRBtn = new RadioButton("Телефон  ");
    final private RadioButton addressRBtn = new RadioButton("Адрес  ");

    final private ToggleGroup group = new ToggleGroup();

    public EditLabourerOptionInputBox() {
        group.getToggles().addAll(idRBtn, lastNameRBtn, firstNameRBtn, patronymicRBtn, phoneRBtn, addressRBtn);
        getChildren().addAll(idRBtn, lastNameRBtn, firstNameRBtn, patronymicRBtn, phoneRBtn, addressRBtn);
    }

    public String toString() {

        if (group.getSelectedToggle() != null) {
            Toggle selectedToggle = group.getSelectedToggle();
            if (idRBtn.equals(selectedToggle)) {
                return "ID";
            }
            else if (lastNameRBtn.equals(selectedToggle)) {
                return "LAST_NAME";
            }
            else if (firstNameRBtn.equals(selectedToggle)) {
                return "FIRST_NAME";
            }
            else if (patronymicRBtn.equals(selectedToggle)) {
                return "PATRONYMIC";
            }
            else if (phoneRBtn.equals(selectedToggle)) {
                return "PHONE";
            }
            else if (addressRBtn.equals(selectedToggle)) {
                return "ADDRESS";
            }
        }
        return "";
    }
}