package View.OptionInputBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;

public class FrequencyInputBox extends HBox {
    final private RadioButton everyDay = new RadioButton("Каждый день");
    final private RadioButton onceAWeek = new RadioButton("Каждую неделю");
    final private RadioButton onceAMonth = new RadioButton("Каждый месяц");
    final private ToggleGroup group = new ToggleGroup();

    public FrequencyInputBox() {
        group.getToggles().addAll(everyDay, onceAWeek, onceAMonth);
        getChildren().addAll(everyDay, onceAWeek, onceAMonth);
    }

    public String toString() {
        if (group.getSelectedToggle() != null) {
            Toggle selectedToggle = group.getSelectedToggle();
            if (everyDay.equals(selectedToggle)) {
                return "Каждый день";
            } else if (onceAWeek.equals(selectedToggle)) {
                return "Каждую неделю";
            } else if (onceAMonth.equals(selectedToggle)) {
                return "Каждый месяц";
            }
            return "С неуказанной частотой";
        }
        return "";
    }
}