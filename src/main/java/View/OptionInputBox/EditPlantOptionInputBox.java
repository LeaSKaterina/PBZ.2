package View.OptionInputBox;

import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;

public class EditPlantOptionInputBox extends VBox {

    final private RadioButton idRBtn = new RadioButton("ID ");
    final private RadioButton dateRBtn = new RadioButton("Дата высадки ");
    final private RadioButton ageRBtn = new RadioButton("Возраст ");
    final private RadioButton typeRBtn = new RadioButton("Тип ");
    final private RadioButton wateringIdRBtn = new RadioButton("ID режима полива   ");
    final private RadioButton frequencyRBtn = new RadioButton("Частота полива ");
    final private RadioButton timeRBtn = new RadioButton("Время полива    ");
    final private RadioButton waterAmountRBtn = new RadioButton("Количество воды в литрах ");

    final private ToggleGroup group = new ToggleGroup();

    public EditPlantOptionInputBox() {
        group.getToggles().addAll(idRBtn, dateRBtn, ageRBtn, typeRBtn, wateringIdRBtn, frequencyRBtn, timeRBtn, waterAmountRBtn);
        getChildren().addAll(idRBtn, dateRBtn, ageRBtn, typeRBtn, wateringIdRBtn, frequencyRBtn, timeRBtn, waterAmountRBtn);
    }

    public String toString() {

        if (group.getSelectedToggle() != null) {
            Toggle selectedToggle = group.getSelectedToggle();
            if (idRBtn.equals(selectedToggle)) {
                return "ID";
            }
            else if (dateRBtn.equals(selectedToggle)) {
                return "DATE";
            }
            else if (ageRBtn.equals(selectedToggle)) {
                return "AGE";
            }
            else if (typeRBtn.equals(selectedToggle)) {
                return "TYPE";
            }
            else if (wateringIdRBtn.equals(selectedToggle)) {
                return "WATERING_ID";
            }
            else if (frequencyRBtn.equals(selectedToggle)) {
                return "FREQUENCY";
            }
            else if (timeRBtn.equals(selectedToggle)) {
                return "TIME";
            }
            else if (waterAmountRBtn.equals(selectedToggle)) {
                return "AMOUNT_OF_WATER";
            }
        }
        return "";
    }

    public boolean editWateringOption(){
        Toggle selectedToggle = group.getSelectedToggle();
        return frequencyRBtn.equals(selectedToggle) || timeRBtn.equals(selectedToggle) || waterAmountRBtn.equals(selectedToggle);
    }

}
